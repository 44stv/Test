package com.sturc.IO.NIO.Paths;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        /*        try {
         *//*            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.deleteIfExists(fileToDelete);*//*

//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//            Files.createDirectories(dirToCreate);

            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
            long byteSize = Files.size(filePath);
            System.out.println("Size = " + byteSize);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + fileAttributes.size());
            System.out.println("Last modified = " + fileAttributes.lastModifiedTime());
            System.out.println("Creation time = " + fileAttributes.creationTime());
            System.out.println("Is directory = " + fileAttributes.isDirectory());
            System.out.println("Is regular file = " + fileAttributes.isRegularFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }*/

//        DirectoryStream.Filter<Path> filter =
//                new DirectoryStream.Filter<Path>() {
//                    @Override
//                    public boolean accept(Path path) throws IOException {
//                        return (Files.isRegularFile(path));
//                    }
//                };
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temp file path = " + tempFile.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println(store + " " + store.type());
        }

        System.out.println("Walking tree dir2");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Copy Dir2 to Dir4/Dir2Copy");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;

            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

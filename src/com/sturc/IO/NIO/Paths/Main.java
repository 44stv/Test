package com.sturc.IO.NIO.Paths;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        try {
/*            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.deleteIfExists(fileToDelete);*/

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
        }





/*        Path fileInDirectory = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(fileInDirectory);
//        Path fileInSubDirectory = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
        Path fileInSubDirectory = Paths.get(".", "files", "SubdirectoryFile.txt");
        printFile(fileInSubDirectory);
//        Path outsideDirectory = Paths.get("D:\\GDrive\\Projects\\OutThere.txt");
        Path outsideDirectory = Paths.get("D:\\", "GDrive\\Projects\\", "OutThere.txt");
        printFile(outsideDirectory);

        Path path1 = Paths.get(".");
        System.out.println(path1.toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());

        Path path4 = Paths.get("D:\\Test\\test", "test.txt");
        System.out.println(path4.toAbsolutePath());

        Path filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exits = " + Files.exists(filePath));

        System.out.println("Exits = " + Files.exists(path4));*/
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

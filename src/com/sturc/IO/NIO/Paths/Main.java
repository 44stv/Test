package com.sturc.IO.NIO.Paths;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        try {
            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.deleteIfExists(fileToDelete);

/*            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.move(fileToMove, destination);*/

/*            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);*/
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

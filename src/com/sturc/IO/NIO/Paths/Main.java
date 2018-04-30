package com.sturc.IO.NIO.Paths;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path fileInDirectory = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(fileInDirectory);
//        Path fileInSubDirectory = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
        Path fileInSubDirectory = Paths.get(".", "files", "SubdirectoryFile.txt");
        printFile(fileInSubDirectory);
//        Path outsideDirectory = Paths.get("D:\\GDrive\\Projects\\OutThere.txt");
        Path outsideDirectory = Paths.get("D:\\", "GDrive\\Projects\\", "OutThere.txt");
        printFile(outsideDirectory);

        Path filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
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

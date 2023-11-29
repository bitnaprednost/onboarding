package hr.bitnaPrednost.day7;

import hr.bitnaPrednost.day7.file.Directory;
import hr.bitnaPrednost.day7.file.FileSystem;
import jdk.jshell.spi.ExecutionControl;
import hr.bitnaPrednost.util.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionControl.NotImplementedException {
        String[] textFromFile = Parser.getLinesFromFile("Resources/day7Data.txt");

        FileSystem fileSystem = ParserDay7.createFileSystem(textFromFile, 70000000);
        long size = fileSystem.sumDirectoriesWithMaxSizeOf(100000);
        System.out.println(size);

        Directory minDirectory = fileSystem.findMinDirectory(30000000);
        System.out.println(minDirectory.getName());
        System.out.println(minDirectory.getSize());
    }
}

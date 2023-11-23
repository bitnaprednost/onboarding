package day7;

import day7.file.Directory;
import day7.file.FileImpl;
import day7.file.FileSystem;
import jdk.jshell.spi.ExecutionControl;
import util.Parser;

import java.security.InvalidParameterException;

public class ParserDay7 implements Parser {
    private static void moveCursor(FileSystem fileSystem, String command) {
        String suffix = command.substring(5);
        switch (suffix) {
            case String s when s.matches("\\.\\.") -> fileSystem.moveCursorBackward();
            case String s when s.matches("/") -> fileSystem.resetCursor();
            default -> fileSystem.moveCursorForward(suffix);
        }

    }

    private static void addFileToFileSystem(FileSystem fileSystem, String command) {
        String[] split = command.split(" ");
        Directory file1 = Directory.from(split[1]);
        fileSystem.addFile(file1);
    }

    private static void addDirectoryToFileSystem(FileSystem fileSystem, String command) {
        String[] split = command.split(" ");
        FileImpl file = FileImpl.from(split[1], Long.parseLong(split[0]));
        fileSystem.addFile(file);
    }

    private static int registerListedFiles(int i, String[] split, FileSystem fileSystem) throws ExecutionControl.NotImplementedException {
        for (int j = i + 1; j < split.length && !split[j].startsWith("$"); j++, i++) {
            switch (split[j]) {
                case String s when s.matches("[0-9].+") -> addDirectoryToFileSystem(fileSystem, split[j]);
                case String s when s.matches("dir.+") -> addFileToFileSystem(fileSystem, split[j]);
                default -> throw new ExecutionControl.NotImplementedException("Command not implemented");
            }
        }
        //function iterates variable i from the last function for loop
        return i;
    }
    public static FileSystem createFileSystem(String inputText, long diskSpace) throws ExecutionControl.NotImplementedException {
        if(!inputText.startsWith("$")) throw new InvalidParameterException("Parameter doesn't start with $");

        FileSystem fileSystem = new FileSystem(diskSpace);

        String[] split = inputText.split("\n");
        for(int i=0;i<split.length;i++){
            switch (split[i]) {
                case String s when s.matches("\\$ cd.+") -> moveCursor(fileSystem, split[i]);
                case String s when s.matches("\\$ ls") -> i = registerListedFiles(i, split, fileSystem);
                default -> throw new ExecutionControl.NotImplementedException("Command not implemented");
            }
        }
        fileSystem.resetCursor();

        return fileSystem;
    }

}

package hr.bitnaPrednost.noSpaceLeftOnDevice;

import hr.bitnaPrednost.noSpaceLeftOnDevice.file.Directory;
import hr.bitnaPrednost.noSpaceLeftOnDevice.file.FileImpl;
import hr.bitnaPrednost.noSpaceLeftOnDevice.file.FileSystem;
import hr.bitnaPrednost.util.Parser;

public class ParserDay7 implements Parser {

    private ParserDay7(){}

    private static void moveCursor(FileSystem fileSystem, String command) {
        String directoryName = command.substring(5);
        switch (directoryName) {
            case String s when s.matches("\\.\\.") -> fileSystem.moveCursorBackward();
            case String s when s.matches("/") -> fileSystem.resetCursor();
            default -> fileSystem.moveCursorForward(directoryName);
        }

    }

    private static void addFileToFileSystem(FileSystem fileSystem, String command) {
        String[] split = command.split(" ");
        Directory file = Directory.from(split[1]);
        fileSystem.addFile(file);
    }

    private static void addDirectoryToFileSystem(FileSystem fileSystem, String command) {
        String[] split = command.split(" ");
        FileImpl file = FileImpl.from(split[1], Long.parseLong(split[0]));
        fileSystem.addFile(file);
    }

    private static int registerListedFiles(int i, String[] split, FileSystem fileSystem){
        //this function iterates variable i from the last functions for loop (until a new line with $ is reached)
        for (int j = i + 1; j < split.length && !split[j].startsWith("$"); j++, i++) {
            switch (split[j]) {
                case String s when s.matches("[0-9].+") -> addDirectoryToFileSystem(fileSystem, split[j]);
                case String s when s.matches("dir.+") -> addFileToFileSystem(fileSystem, split[j]);
                default -> throw new UnsupportedOperationException("After ls executed: command not implemented.");
            }
        }
        return i;
    }
    public static FileSystem createFileSystem(String[] inputText, long diskSpace){
        if(!inputText[0].startsWith("$ cd")) throw new IllegalArgumentException("First parameter doesn't start with $ cd.");
        FileSystem fileSystem = new FileSystem(diskSpace);

        for(int i=0;i<inputText.length;i++){
            switch (inputText[i]) {
                case String s when s.matches("\\$ cd.+") -> moveCursor(fileSystem, inputText[i]);
                case String s when s.matches("\\$ ls") -> i = registerListedFiles(i, inputText, fileSystem);
                default -> throw new UnsupportedOperationException("Command not implemented.");
            }
        }
        fileSystem.resetCursor();

        return fileSystem;
    }

}

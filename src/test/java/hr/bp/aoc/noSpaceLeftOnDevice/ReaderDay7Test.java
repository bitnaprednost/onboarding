package hr.bp.aoc.noSpaceLeftOnDevice;

import hr.bp.aoc.noSpaceLeftOnDevice.file.FileSystem;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import hr.bp.aoc.util.Reader;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderDay7Test {
    private String inputText;
    private String[] split;

    @BeforeEach
    void init(){
        inputText = """
                $ cd /
                $ ls
                dir a
                14848514 b.txt
                8504156 c.dat
                dir d
                $ cd a
                $ ls
                dir e
                29116 f
                2557 g
                62596 h.lst
                $ cd ..
                $ cd ..
                $ cd d
                $ ls
                584 i
                """;
        split = inputText.split("\n");
    }

    @Test
    public void parserCanGetInitialInput() throws IOException {
        Path path = Path.of("src/test/resources/testData.txt");
        String initialInput = Reader.getTextFromFile(path);

        assertEquals(initialInput, "Hello World\n" + "this is a test");
    }

    @Test
    public void canConvertTextIntoFileSystem() throws ExecutionControl.NotImplementedException {
        FileSystem fileSystem = ReaderDay7.createFileSystem(split, 70000);

        assertAll("All values are correct in current cursor",
                () -> assertNotNull(fileSystem),
                () -> assertEquals(fileSystem.getCurrent().getName(), "/"),
                () -> assertEquals(fileSystem.getFileFromPosition(0).getName(), "a"),
                () -> assertEquals(fileSystem.getFileFromPosition(1).getName(), "b.txt"),
                () -> assertEquals(fileSystem.getFileFromPosition(2).getName(), "c.dat"),
                () -> assertEquals(fileSystem.getFileFromPosition(3).getName(), "d"),
                () -> assertEquals(fileSystem.getFileFromPosition(0).getType(), "directory"),
                () -> assertEquals(fileSystem.getFileFromPosition(1).getType(), "file"),
                () -> assertEquals(fileSystem.getFileFromPosition(2).getType(), "file"),
                () -> assertEquals(fileSystem.getFileFromPosition(3).getType(), "directory")
                );


        //test cursor forward
        fileSystem.moveCursorForward("a");
        assertAll("All values are correct in next cursor",
                () -> assertEquals(fileSystem.getFileFromPosition(0).getName(), "e"),
                () -> assertEquals(fileSystem.getFileFromPosition(1).getName(), "f"),
                () -> assertEquals(fileSystem.getFileFromPosition(2).getName(), "g"),
                () -> assertEquals(fileSystem.getFileFromPosition(3).getName(), "h.lst"),
                () -> assertEquals(fileSystem.getFileFromPosition(0).getType(), "directory"),
                () -> assertEquals(fileSystem.getFileFromPosition(1).getType(), "file"),
                () -> assertEquals(fileSystem.getFileFromPosition(2).getType(), "file"),
                () -> assertEquals(fileSystem.getFileFromPosition(3).getType(), "file")
                );


        //test cursor backwards
        fileSystem.moveCursorBackward();
        fileSystem.moveCursorForward("d");
        assertAll("All values are correct in next cursor",
                () -> assertEquals(fileSystem.getFileFromPosition(0).getName(), "i"),
                () -> assertEquals(fileSystem.getFileFromPosition(0).getType(), "file")
        );
    }

    @Test
    public void cantParseWrongStart(){
        String[] testStr = {"Hello", "World"};
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->{FileSystem fileSystem = ReaderDay7.createFileSystem(testStr, 70000);});
        assertEquals("First parameter doesn't start with $ cd.", thrown.getMessage());
    }

    @Test
    public void cantParseWrongCommand(){
        String[] testStr = {"$ cd /", "mirko"};
        UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, ()->{FileSystem fileSystem = ReaderDay7.createFileSystem(testStr, 70000);});
        assertEquals("Command not implemented.", thrown.getMessage());
    }

    @Test
    public void cantParseWrongCommandInls(){
        String[] testStr = {"$ cd /", "$ ls", "mirko"};
        UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, ()->{FileSystem fileSystem = ReaderDay7.createFileSystem(testStr, 70000);});
        assertEquals("After ls executed: command not implemented.", thrown.getMessage());
    }
}
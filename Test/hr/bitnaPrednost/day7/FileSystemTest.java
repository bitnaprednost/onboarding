package hr.bitnaPrednost.day7;

import hr.bitnaPrednost.day7.file.Directory;
import hr.bitnaPrednost.day7.file.File;
import hr.bitnaPrednost.day7.file.FileImpl;
import hr.bitnaPrednost.day7.file.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    private Directory testDirectoryFile;
    private FileImpl testFileFile;
    private FileSystem fileSystem;
    @BeforeEach
    void init(){
        testFileFile = FileImpl.from("i", 2000);
        testDirectoryFile = Directory.from("/");
        fileSystem = new FileSystem(10000);
    }

    @Test
    public void canAddFile(){
        fileSystem.addFile(testDirectoryFile);
        assertEquals(fileSystem.getFileFromPosition(0), testDirectoryFile);
    }

    @Test
    public void canGetFromPosition(){
        fileSystem.addFile(testFileFile);
        FileImpl file2 = FileImpl.from("j", 3000);
        fileSystem.addFile(file2);
        File dir = fileSystem.getFileFromPosition(1);

        assertEquals(dir, file2);
    }

    @Test
    public void canFindDirectory(){
        File testFile2 = Directory.from("a");
        fileSystem.addFile(testFile2);
        File dir = fileSystem.findFirstDirectory("a");

        assertEquals(dir, testFile2);
        assertEquals(dir.getType(), "directory");
    }

    @Test
    public void findFirstFileRecognisesTypes(){
        assertThrows(NoSuchElementException.class, () -> {File dir = fileSystem.findFirstFile("/");});
    }

    @Test
    public void canFindFile(){
        fileSystem.addFile(testFileFile);
        File dir = fileSystem.findFirstFile("i");

        assertEquals(dir, testFileFile);
        assertEquals(dir.getType(), "file");
    }

    @Test
    public void canAddToNestedFile(){
        Directory testFile2 = Directory.from("a");
        fileSystem.addFile(testFile2);
        fileSystem.addFile(testFile2, testFileFile);

        Directory dir = (Directory) fileSystem.getFileFromPosition(0);
        File dir2 = dir.getFileFromPosition(0);

        assertEquals(dir2, testFileFile);
        assertEquals(dir2.getType(), "file");
    }

    @Test
    public void canFindNestedFile(){
        File testFile2 = Directory.from("a");
        fileSystem.addFile(testFile2);
        fileSystem.addFile(testFileFile);
        File dir = fileSystem.findFirstFile("i");

        assertEquals(dir, testFileFile);
        assertEquals(dir.getType(), "file");
    }

    @Test
    public void canMoveCursorForward(){
        Directory testFile2 = Directory.from("a");
        fileSystem.addFile(testFile2);
        fileSystem.moveCursorForward("a");

        assertEquals("a", fileSystem.getCurrent().getName());
    }

    @Test
    public void canMoveCursorBackwards(){
        Directory testFile2 = Directory.from("a");
        fileSystem.addFile(testFile2);
        Directory testFile3 = Directory.from("b");
        fileSystem.addFile(testFile2, testFile3);

        fileSystem.moveCursorForward("a");
        fileSystem.moveCursorForward("b");
        fileSystem.moveCursorBackward();
        fileSystem.moveCursorBackward();

        assertEquals("/", fileSystem.getCurrent().getName());
    }

    @Test void canResetCursor(){
        Directory testFile2 = Directory.from("a");
        fileSystem.addFile(testFile2);
        Directory testFile3 = Directory.from("b");
        fileSystem.addFile(testFile2, testFile3);

        fileSystem.moveCursorForward("a");
        fileSystem.moveCursorForward("b");
        fileSystem.resetCursor();

        assertEquals("/", fileSystem.getCurrent().getName());
    }

    @Test
    public void canGetSize(){
        fileSystem.addFile(testFileFile);
        FileImpl file2 = FileImpl.from("j", 3000);
        fileSystem.addFile(file2);

        long sum = fileSystem.getSize();
        assertEquals(sum, 5000L);
    }

    @Test
    public void canGetSizeBiggerTest(){
        fileSystem.addFile(testFileFile);
        Directory directory1 = Directory.from("a");
        fileSystem.addFile(directory1, testFileFile);
        fileSystem.addFile(directory1);

        Directory directory2 = Directory.from("b");
        fileSystem.addFile(directory2, testFileFile);
        FileImpl file4 = FileImpl.from("j", 3000);
        fileSystem.addFile(directory2, file4);
        fileSystem.addFile(directory2);

        long sum = fileSystem.getSize();
        assertEquals(sum, 9000L);
    }

    @Test
    public void canGetSumOfAllDirectoriesSizes(){
        fileSystem.addFile(testFileFile);
        Directory directory1 = Directory.from("a");
        fileSystem.addFile(directory1, testFileFile);
        fileSystem.addFile(directory1);

        Directory directory2 = Directory.from("b");
        fileSystem.addFile(directory2, testFileFile);
        FileImpl file4 = FileImpl.from("j", 3000);
        fileSystem.addFile(directory2, file4);
        fileSystem.addFile(directory2);

        long sum = fileSystem.sumDirectoriesWithMaxSizeOf(5000);
        assertEquals(sum, 7000L);
    }

    @Test
    public void canFindDirectoryWithMinimumRequiredSize(){
        fileSystem.addFile(testFileFile);
        Directory directory1 = Directory.from("a");
        fileSystem.addFile(directory1, testFileFile);
        fileSystem.addFile(directory1);

        Directory directory2 = Directory.from("b");
        fileSystem.addFile(directory2, testFileFile);
        FileImpl file4 = FileImpl.from("j", 3000);
        fileSystem.addFile(directory2, file4);
        fileSystem.addFile(directory2);

        long capacity = 5000;
        //capacity = 10000 - 6000 = 4000
        //left = 10000 - 9000 = 1000
        Directory minDirectory = fileSystem.findMinDirectory(capacity);

        assertEquals(minDirectory.getName(), "b");
        assertEquals(minDirectory.getSize(), 5000L);
    }

}
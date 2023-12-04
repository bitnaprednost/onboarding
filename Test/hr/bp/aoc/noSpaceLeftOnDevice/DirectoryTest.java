package hr.bp.aoc.noSpaceLeftOnDevice;

import hr.bp.aoc.noSpaceLeftOnDevice.file.Directory;
import hr.bp.aoc.noSpaceLeftOnDevice.file.File;
import hr.bp.aoc.noSpaceLeftOnDevice.file.FileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private Directory directory;
    private FileImpl file;
    @BeforeEach
    void setUp() {
        file = FileImpl.from("i", 2000);
        directory = Directory.from("/");
    }

    @Test
    public void canGetName(){
        assertEquals(directory.getName(), "/");
    }

    @Test
    public void canGetType(){
        assertEquals(directory.getType(), "directory");
    }

    @Test
    public void canGetFromPosition(){
        directory.addFile(file);
        FileImpl file2 = FileImpl.from("j", 3000);
        directory.addFile(file2);
        File dir = directory.getFileFromPosition(1);

        assertEquals(dir, file2);
    }

    @Test
    public void canFindDirectory(){
        Directory testFile = Directory.from("a");
        directory.addFile(testFile);
        File dir = directory.findFirstDirectory("a");

        assertEquals(dir, testFile);
        assertEquals(dir.getType(), "directory");
    }

    @Test
    public void canFindFile(){
        directory.addFile(file);
        File dir = directory.findFirstFile("i");

        assertEquals(dir, file);
        assertEquals(dir.getType(), "file");
    }

    @Test
    public void canFindNestedFile(){
        Directory testFile2 = Directory.from("a");
        directory.addFile(testFile2);
        testFile2.addFile(file);
        File dir = directory.findFirstFile("i");

        assertEquals(dir, file);
        assertEquals(dir.getType(), "file");
    }

    @Test
    public void canFindShallow(){
        File testFile2 = Directory.from("i");
        directory.addFile(testFile2);
        File dir = directory.findShallow("i");

        assertEquals(dir, testFile2);
        assertEquals(dir.getType(), "directory");
    }

    @Test
    public void canGetSize(){
        directory.addFile(file);
        FileImpl file2 = FileImpl.from("j", 3000);
        directory.addFile(file2);

        long sum = directory.getSize();
        assertEquals(sum, 5000);
    }

    @Test
    public void canGetSizeBiggerTest(){
        directory.addFile(file);
        Directory directory1 = Directory.from("a");
        directory.addFile(directory1);
        FileImpl file2 = FileImpl.from("j", 3000);
        directory1.addFile(file2);

        Directory directory2 = Directory.from("b");
        directory.addFile(directory2);
        FileImpl file3 = FileImpl.from("j", 2000);
        directory2.addFile(file3);
        FileImpl file4 = FileImpl.from("i", 3000);
        directory2.addFile(file4);

        long sum = directory.getSize();
        assertEquals(sum, 10000);
    }

    @Test
    public void canGetAllDirectoriesWithMaxSizeOf(){
        directory.addFile(file);

        Directory directory1 = Directory.from("a");
        directory1.addFile(file);
        directory.addFile(directory1);

        Directory directory2 = Directory.from("b");
        directory2.addFile(file);
        FileImpl file4 = FileImpl.from("j", 3000);
        directory2.addFile(file4);
        directory.addFile(directory2);

        List<Directory> list = new ArrayList<>();
        directory.getSizeCriterion(list, 5000);

        assertAll("Containes all valid components.",
                ()->assertEquals(list.size(), 2),
                ()->assertEquals(list.get(0).getName(), "a"),
                ()->assertEquals(list.get(1).getName(), "b")
        );
    }
}
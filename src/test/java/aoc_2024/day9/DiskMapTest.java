package aoc_2024.day9;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskMapTest {

    DiskMap diskMap = new DiskMap();

    @Test
    void calculateChecksum_example() {
        String input = "2333133121414131402";

        diskMap.parseFilesAndFreeSpace(input);
        diskMap.moveFileBlocks();

        assertEquals(1928, diskMap.calculateChecksum());
    }

    @Test
    void calculateChecksum_input_puzzle(){
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day9/DiskMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        diskMap.parseFilesAndFreeSpace(fileContent);
        diskMap.moveFileBlocks();

        assertEquals(6461289671426L, diskMap.calculateChecksum());
    }

    @Test
    void calculateChecksum_example2() {
        String input = "2333133121414131402";

        diskMap.parseFilesAndFreeSpace(input);
        diskMap.moveWholeFiles();

        assertEquals(2858, diskMap.calculateChecksum());
    }

    @Test
    void calculateChecksum_input_puzzle2(){
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day9/DiskMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        diskMap.parseFilesAndFreeSpace(fileContent);
        diskMap.moveWholeFiles();

        assertEquals(6488291456470L, diskMap.calculateChecksum());
    }

}
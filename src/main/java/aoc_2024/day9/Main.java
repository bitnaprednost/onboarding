package aoc_2024.day9;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day9/DiskMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        DiskMap diskMap = new DiskMap();
        diskMap.parseFilesAndFreeSpace(fileContent);
        diskMap.moveFileBlocks();

        logger.debug("Resulting filesystem checksum is: {}", diskMap.calculateChecksum());

        DiskMap diskMap2 = new DiskMap();
        diskMap2.parseFilesAndFreeSpace(fileContent);
        diskMap2.moveWholeFiles();

        logger.debug("Resulting filesystem checksum is: {}", diskMap2.calculateChecksum());

    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}

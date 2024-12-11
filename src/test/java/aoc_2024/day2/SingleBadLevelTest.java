package aoc_2024.day2;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleBadLevelTest {

    SingleBadLevel BadLevelReports = new SingleBadLevel();

    @Test
    void calculateSafeReports_example() {
        String input = """
                        7 6 4 2 1
                        1 2 7 8 9
                        9 7 6 2 1
                        1 3 2 4 5
                        8 6 4 4 1
                        1 3 6 7 9""";

        assertEquals(4, BadLevelReports.calculateSafeReports(input));
    }

    @Test
    void calculateSafeReports_puzzle_input(){
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day2/reports.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(337,BadLevelReports.calculateSafeReports(fileContent));
    }

}
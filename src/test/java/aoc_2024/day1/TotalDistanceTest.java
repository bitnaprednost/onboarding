package aoc_2024.day1;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TotalDistanceTest {

    TotalDistance totalDistance = new TotalDistance();

    @Test
    void calculateTotalDistance_example() {
        String input = """
                        3   4
                        4   3
                        2   5
                        1   3
                        3   9
                        3   3""";

        assertEquals(11, totalDistance.calculateTotalDistance(input));
    }

    @Test
    void calculateTotalDistance_puzzle_input(){

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day1/locationIDs.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(2264607, totalDistance.calculateTotalDistance(fileContent));

    }
}
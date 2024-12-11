package aoc_2024.day6;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardLoopDetectorTest {

    @Test
    void findLoopObstructions_example() {

        String input = """
                ....#.....
                .........#
                ..........
                ..#.......
                .......#..
                ..........
                .#..^.....
                ........#.
                #.........
                ......#...
                """;
        GuardLoopDetector guardLoopDetector = new GuardLoopDetector(input);

        assertEquals(6, guardLoopDetector.findLoopObstructions());
    }

    @Test
    void findLoopObstructions_input_puzzle() {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day6/Map.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        GuardLoopDetector guardLoopDetector = new GuardLoopDetector(fileContent);

        assertEquals(1480, guardLoopDetector.findLoopObstructions());


    }
}
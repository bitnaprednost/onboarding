package aoc_2024.day6;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardMappedAreaTest {

    @Test
    void getNumDistinctPosition_example() {

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

        GuardMappedArea guardMappedArea = new GuardMappedArea(input);
        assertEquals(41, guardMappedArea.getNumDistinctPosition());
    }

    @Test
    void getNumDistinctPosition_input_puzzle(){

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day6/Map.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        GuardMappedArea guardMappedArea = new GuardMappedArea(fileContent);
        assertEquals(4580, guardMappedArea.getNumDistinctPosition());
    }
}
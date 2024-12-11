package aoc_2024.day8;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AntennaMapTest {
    AntennaMap map = new AntennaMap();

    @Test
    void calculateUniqueLocations_example() {

        String input = """
                ............
                ........0...
                .....0......
                .......0....
                ....0.......
                ......A.....
                ............
                ............
                ........A...
                .........A..
                ............
                ............
                """;

        assertEquals(14, map.calculateUniqueLocations(input));
    }

    @Test
    void calculateUniqueLocations_input_puzzle() {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day8/AntennaMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(359, map.calculateUniqueLocations(fileContent));
    }

}
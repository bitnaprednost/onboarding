package aoc_2024.day10;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingTrailTest {
    HikingTrail hikingTrail = new HikingTrail();

    @Test
    void findHikingTrailScore_example() {
        String input = """
                89010123
                78121874
                87430965
                96549874
                45678903
                32019012
                01329801
                10456732
                """;

        assertEquals(36, hikingTrail.findHikingTrailScore(input));
    }

    @Test
    void findHikingTrailScore_input_puzzle() {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day10/HikingMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(644, hikingTrail.findHikingTrailScore(fileContent));
    }

    @Test
    void findHikingTrailRating_example() {
        String input = """
                89010123
                78121874
                87430965
                96549874
                45678903
                32019012
                01329801
                10456732
                """;

        assertEquals(81, hikingTrail.findHikingTrailRating(input));
    }

    @Test
    void findHikingTrailRating_input_puzzle() {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day10/HikingMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(1366, hikingTrail.findHikingTrailRating(fileContent));
    }
}
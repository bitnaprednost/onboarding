package aoc_2024.day11;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StonesTest {

    Stones stones = new Stones();

    @Test
    void getStonesNumber_example1() {

        String input = """
                125 17
                """;

        stones.setNumberOfBlinks(6);
        assertEquals(22, stones.getStonesNumber(input));
    }

    @Test
    void getStonesNumber_example2() {

        String input = """
                125 17
                """;

        stones.setNumberOfBlinks(25);
        assertEquals(55312, stones.getStonesNumber(input));
    }

    @Test
    void getStonesNumber_input_puzzle() {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day11/Stones.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        stones.setNumberOfBlinks(25);
        assertEquals(198075, stones.getStonesNumber(fileContent));
    }

    @Test
    void getStonesNumber_input_puzzle2() {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day11/Stones.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        stones.setNumberOfBlinks(75);
        assertEquals(235571309320764L, stones.getStonesNumber(fileContent));
    }
}
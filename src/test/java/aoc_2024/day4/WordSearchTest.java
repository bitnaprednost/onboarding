package aoc_2024.day4;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    WordSearch search = new WordSearch();

    @Test
    void wordSearch_example() {
        String input = """
                        MMMSXXMASM
                        MSAMXMSMSA
                        AMXSXMAAMM
                        MSAMASMSMX
                        XMASAMXAMM
                        XXAMMXXAMA
                        SMSMSASXSS
                        SAXAMASAAA
                        MAMMMXMMMM
                        MXMXAXMASX
                        """;

        assertEquals(18, search.wordSearch(input));
    }

    @Test
    void wordSearch_input_puzzle(){

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day4/WordSearch.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(2543, search.wordSearch(fileContent));

    }
}
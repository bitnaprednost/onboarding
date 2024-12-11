package aoc_2024.day4;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearch2Test {

    WordSearch2 search = new WordSearch2();

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

        assertEquals(9 , search.wordSearch(input));
    }

    @Test
    void wordSearch_input_puzzle(){

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day4/WordSearch.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(1930, search.wordSearch(fileContent));

    }

}
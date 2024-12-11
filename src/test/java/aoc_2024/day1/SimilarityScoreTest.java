package aoc_2024.day1;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityScoreTest {

    SimilarityScore similarityScore = new SimilarityScore();

    @Test
    void calculateSimilarityScore_example() {

        String input = """
                        3   4
                        4   3
                        2   5
                        1   3
                        3   9
                        3   3""";

        assertEquals(31, similarityScore.calculateSimilarityScore(input));

    }

    @Test
    void calculateSimilarityScore_puzzle_input(){

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day1/locationIDs.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(19457120, similarityScore.calculateSimilarityScore(fileContent));

    }
}
package aoc_2024.day3;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MulSequenceWithEnableTest {

    MulSequenceWithEnable mulSequenceWithEnable = new MulSequenceWithEnable();

    @Test
    void findMulSequence_example() {

        String input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5)";

        assertEquals(48, mulSequenceWithEnable.findMulSequence(input, "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)"));

    }

    @Test
    void findMulSequence_puzzle_input(){
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day3/CorruptedMemory.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(90669332, mulSequenceWithEnable.findMulSequence(fileContent, "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)"));
    }

}
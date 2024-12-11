package aoc_2024.day3;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MulSequenceTest {

    MulSequence mulSequence = new MulSequence();

    @Test
    void findMulSequence_example() {

        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        assertEquals(161, mulSequence.findMulSequence(input, "mul\\((\\d+),(\\d+)\\)"));

    }

    @Test
    void findMulSequence_puzzle_input(){
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day3/CorruptedMemory.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(173419328, mulSequence.findMulSequence(fileContent, "mul\\((\\d+),(\\d+)\\)"));
    }
}
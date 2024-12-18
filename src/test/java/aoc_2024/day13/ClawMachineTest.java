package aoc_2024.day13;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClawMachineTest {

    ClawMachine clawMachine = new ClawMachine();

    @Test
    void getMinToken_example1() {

        String input = """
                Button A: X+94, Y+34
                Button B: X+22, Y+67
                Prize: X=8400, Y=5400
                
                Button A: X+26, Y+66
                Button B: X+67, Y+21
                Prize: X=12748, Y=12176
                
                Button A: X+17, Y+86
                Button B: X+84, Y+37
                Prize: X=7870, Y=6450
                
                Button A: X+69, Y+23
                Button B: X+27, Y+71
                Prize: X=18641, Y=10279
                """;

        assertEquals(480, clawMachine.getMinToken(input));
    }

    @Test
    void getMinToken_input_puzzle() {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day13/ButtonPrizeInput.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(28262, clawMachine.getMinToken(fileContent));
    }

    @Test
    void getMinToken_input_puzzle2() {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day13/ButtonPrizeInput.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(101406661266314L, clawMachine.getMinTokenUnitConversion(fileContent));
    }
}
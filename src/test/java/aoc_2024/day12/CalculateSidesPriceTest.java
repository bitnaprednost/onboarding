package aoc_2024.day12;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateSidesPriceTest {

    CalculateSidesPrice gardenPlot = new CalculateSidesPrice();

    @Test
    void calculateCost_example1() {

        String input = """
                AAAA
                BBCD
                BBCC
                EEEC
                """;

        assertEquals(80, gardenPlot.calculateTotalCost(input));
    }

    @Test
    void calculateCost_example2() {

        String input = """
                OOOOO
                OXOXO
                OOOOO
                OXOXO
                OOOOO
                """;

        assertEquals(436, gardenPlot.calculateTotalCost(input));
    }

    @Test
    void calculateCost_example3() {

        String input = """
                RRRRIICCFF
                RRRRIICCCF
                VVRRRCCFFF
                VVRCCCJFFF
                VVVVCJJCFE
                VVIVCCJJEE
                VVIIICJJEE
                MIIIIIJJEE
                MIIISIJEEE
                MMMISSJEEE
                """;

        assertEquals(1206, gardenPlot.calculateTotalCost(input));
    }

    @Test
    void calculateCost_example4() {

        String input = """
                EEEEE
                EXXXX
                EEEEE
                EXXXX
                EEEEE
                """;

        assertEquals(236, gardenPlot.calculateTotalCost(input));
    }

    @Test
    void calculateCost_example5() {

        String input = """
                AAAAAA
                AAABBA
                AAABBA
                ABBAAA
                ABBAAA
                AAAAAA
                """;

        assertEquals(368, gardenPlot.calculateTotalCost(input));
    }

    @Test
    void calculateCost_input_puzzle() {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day12/GardenMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(1370100, gardenPlot.calculateTotalCost(fileContent));
    }
}
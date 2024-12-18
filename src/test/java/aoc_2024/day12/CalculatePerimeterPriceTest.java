package aoc_2024.day12;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatePerimeterPriceTest {

    CalculatePerimeterPrice gardenPlot = new CalculatePerimeterPrice();

    @Test
    void calculateCost_example1() {

        String input = """
                AAAA
                BBCD
                BBCC
                EEEC
                """;

        assertEquals(140, gardenPlot.calculateTotalCost(input));
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

        assertEquals(772, gardenPlot.calculateTotalCost(input));
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

        assertEquals(1930, gardenPlot.calculateTotalCost(input));
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
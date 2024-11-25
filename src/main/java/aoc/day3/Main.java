package aoc.day3;

import aoc.io.ReadFile;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "day3/engine_schematic.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Calculate the sum of part numbers
        SumPartNumbers partNum = new SumPartNumbers();
        int totalSum = partNum.sumPartNumbers(fileContent);

        System.out.println("Total sum of part numbers is: " + totalSum);

        // Calculate the sum of gear ratios
        SumGearRatio gearRatio = new SumGearRatio();
        int totalSumGearRatio = gearRatio.sumGearRatio(fileContent);

        System.out.println("Total sum of gear ratio is: " + totalSumGearRatio);
    }
}

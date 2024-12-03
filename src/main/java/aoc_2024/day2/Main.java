package aoc_2024.day2;

import io.ReadFile;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day2/reports.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // solve task 1
        SafeReports Reports = new SafeReports();
        int report_num = Reports.calculateSafeReports(fileContent);

        System.out.println("Number of safe reports: " + report_num);

        // solve task 2
        SingleBadLevel BadLevelReports = new SingleBadLevel();
        report_num = BadLevelReports.calculateSafeReports(fileContent);

        System.out.println("Number of safe reports with one bad level: " + report_num);
    }
}

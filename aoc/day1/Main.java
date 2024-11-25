package day1;

import io.ReadFile;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "day1/calibration_document.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Calculate the sum of calibration values
        CalibrationSum calibration = new CalibrationSum();
        int totalSum = calibration.calibrationSum(fileContent);

        // Print the total sum
        System.out.println("Total sum of calibration values: " + totalSum);

        // Calculate the sum of calibration values with spelled numbers
        CalibrationSumWithSpelling calibrationSpelled = new CalibrationSumWithSpelling();
        int totalSumspelled = calibrationSpelled.calibrationSumWithSpelling(fileContent);

        // Print the total sum
        System.out.println("Total sum of calibration values: " + totalSumspelled);

    }
}

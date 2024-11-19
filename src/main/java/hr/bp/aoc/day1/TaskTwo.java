package hr.bp.aoc.day1;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("inputTaskOne.txt");
        CalibrationDocumentReader calibrationReader = new CalibrationDocumentReader(document, new CalibrationReaderDigitAndStringStrategy());

        System.out.println(calibrationReader.calibration());
    }
}

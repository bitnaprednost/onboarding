package hr.bp.aoc.day1;

import hr.bp.aoc.Utils;

import java.util.List;


public class TaskOne {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("inputDay1.txt");
        CalibrationDocumentReader calibrationReader = new CalibrationDocumentReader(document, new CalibrationReaderDigitStrategy());

        System.out.println(calibrationReader.calibration());
    }
}

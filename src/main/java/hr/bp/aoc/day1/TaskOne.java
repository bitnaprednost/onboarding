package hr.bp.aoc.day1;

import java.net.URL;
import java.util.List;


public class TaskOne {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("inputTaskOne.txt");
        CalibrationDocumentReader calibrationReader = new CalibrationDocumentReader(document);

        System.out.println(calibrationReader.calibration());
    }
}

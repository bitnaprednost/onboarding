package hr.bp.aoc.day1;

import java.util.List;

public class CalibrationDocumentReader {
    private List<String> document;
    private ReadingStrategy strategy;


    public CalibrationDocumentReader(List<String> document) {
        this.document = document;
        this.strategy = new CalibrationReaderStrategy();
    }

    public List<String> getDocument() {
        return document;
    }

    public void setDocument(List<String> document) {
        this.document = document;
    }

    public ReadingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ReadingStrategy strategy) {
        this.strategy = strategy;
    }

    public int calibration() {
        int calibrationSum = 0;

        for (String calibration : document) {
            calibrationSum += strategy.parseDocument(calibration);
        }

        return calibrationSum;
    }

}

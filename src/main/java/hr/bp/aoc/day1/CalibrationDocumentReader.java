package hr.bp.aoc.day1;

public class CalibrationDocumentReader {
    private String document;
    private ReadingStrategy strategy;

    public CalibrationDocumentReader(String document, ReadingStrategy strategy) {
        this.document = document;
        this.strategy = strategy;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public ReadingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ReadingStrategy strategy) {
        this.strategy = strategy;
    }

    public int calibration() {
        return strategy.parseDocument(document);
    }
}
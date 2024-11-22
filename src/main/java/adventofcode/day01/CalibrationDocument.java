package adventofcode.day01;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class CalibrationDocument {

    private final List<String> lines;
    private final CalibrationValueExtractionStrategy extractionStrategy;

    public CalibrationDocument(List<String> lines, CalibrationValueExtractionStrategy extractionStrategy) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Lines must not be null or empty.");
        }
        this.lines = lines;
        this.extractionStrategy = extractionStrategy;
    }

    public int calculateCalibrationValuesSum() {
        int sum = 0;
        for (String line : lines) {
            sum += extractionStrategy.extractCalibrationValueFromLine(line);
        }
        return sum;
    }
}

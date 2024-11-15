package adventofcode.day01;

import java.util.List;

public class CalibrationDocument {

    private final List<String> lines;
    private final LineProcessingDecorator decorator;

    public CalibrationDocument(List<String> lines, LineProcessingDecorator decorator) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Lines must not be null or empty.");
        }
        this.lines = lines;
        this.decorator = decorator;
    }

    public int calculateCalibrationValuesSum() {
        int sum = 0;
        for (String line : lines) {
            sum += decorator.extractCalibrationValueFromLine(line);
        }
        return sum;
    }
}


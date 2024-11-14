package adventofcode.day01;

import java.util.List;

public class CalibrationDocument {

    private final List<String> lines;

    public CalibrationDocument(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Lines must not be null or empty.");
        }
        this.lines = lines;
    }

    public int calculateCalibrationValuesSum() {
        int sum = 0;
        for (String line : lines) {
            sum += extractCalibrationValueFromLine(line);
        }
        return sum;
    }

    private int extractCalibrationValueFromLine(String line) {
        int leftNumber = getLeftmostNumber(line);
        int rightNumber = getRightmostNumber(line);
        return leftNumber*10 + rightNumber;
    }

    private int getLeftmostNumber(String line) {
        return getTheFirstNumberEncountered(line);
    }

    private int getRightmostNumber(String line) {
        String reversedLine = new StringBuilder(line).reverse().toString();
        return getTheFirstNumberEncountered(reversedLine);
    }

    private int getTheFirstNumberEncountered(String line) {
        char[] charArray = line.toCharArray();
        for (char character : charArray) {
            if (Character.isDigit(character)) {
                return Integer.parseInt(Character.toString(character));
            }
        }
        throw new IllegalArgumentException("No number found");
    }
}

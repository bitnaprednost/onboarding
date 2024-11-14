package adventofcode.day01;

import java.util.Arrays;
import java.util.List;

public class CalibrationDocument {

    private List<String> lines;

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void setLinesFromInputString(String inputString) {
        this.lines = Arrays.asList(inputString.split("\n", -1));
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

    public void displayCalibrationValuesSum(int sum) {
        System.out.println(String.format("Sum of calibration values is %s.", sum));
    }
}

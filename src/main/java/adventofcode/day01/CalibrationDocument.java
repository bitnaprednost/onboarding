package adventofcode.day01;

import java.util.Arrays;
import java.util.List;

public class CalibrationDocument {

    private List<String> lines;

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void setLinesFromInputString(String inputString) {
        this.lines = Arrays.asList(inputString.split("\n"));
    }

    public int calculateSumOfCalibrationValues() {
        int sum = 0;
        for (String line : lines) {
            sum += extractCalibrationValueFromLine(line);
        }
        return sum;
    }

    private int extractCalibrationValueFromLine(String line) {
        int leftNumber = getLeftNumber(line);
        int rightNumber = getRightNumber(line);
        return leftNumber*10 + rightNumber;
    }

    private int getLeftNumber(String line) {
        char[] lineAsCharArray = line.toCharArray();
        for (int i = 0; i < lineAsCharArray.length ; i++) {
            char character = lineAsCharArray[i];
            if (Character.isDigit(character)) {
                return Integer.parseInt(Character.toString(character));
            }
        }
        return Integer.MIN_VALUE;
    }

    private int getRightNumber(String line) {
        char[] lineAsCharArray = line.toCharArray();
        for (int i = lineAsCharArray.length - 1; i >=0 ; i--) {
            char character = lineAsCharArray[i];
            if (Character.isDigit(character)) {
                return Integer.parseInt(Character.toString(character));
            }
        }
        return Integer.MIN_VALUE;
    }
}

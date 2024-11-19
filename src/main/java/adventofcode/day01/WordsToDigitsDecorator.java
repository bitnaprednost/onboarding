package adventofcode.day01;

import adventofcode.day01.text.DigitWordEnum;

public class WordsToDigitsDecorator extends ExtractionStrategyDecorator {

    public WordsToDigitsDecorator(CalibrationValueExtractionStrategy strategy) {
        super(strategy);
    }

    @Override
    public int extractCalibrationValueFromLine(String line) {
        String preprocessedLine = preprocessLine(line);
        return strategy.extractCalibrationValueFromLine(preprocessedLine);
    }

    private String preprocessLine(String line) {
        StringBuilder newLine = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                appendDigit(line, newLine, i);
            } else {
                appendPotentialWordAsADigit(line, newLine, i);
            }
        }
        return newLine.toString();
    }

    private static void appendDigit(String line, StringBuilder newLine, int i) {
        newLine.append(line.charAt(i));
    }

    private static void appendPotentialWordAsADigit(String line, StringBuilder newLine, int i) {
        StringBuilder potentialNumberAsString = new StringBuilder();
        potentialNumberAsString.append(line.charAt(i));
        for (int j = i +1; j < line.length() && j < i +5; j++) {
            potentialNumberAsString.append(line.charAt(j));
            if (DigitWordEnum.getValuesAsLowercase().contains(potentialNumberAsString.toString())) {
                newLine.append(DigitWordEnum.valueOf(potentialNumberAsString.toString().toUpperCase()).getIntValue());
                break;
            }
        }
    }
}
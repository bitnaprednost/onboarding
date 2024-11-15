package adventofcode.day01;

public class WordsToNumbersDecorator extends ExtractionStrategyDecorator {

    public WordsToNumbersDecorator(CalibrationValueExtractionStrategy strategy) {
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
                newLine.append(line.charAt(i));
            } else {
                appendPotentialNumberAsString(line, i, newLine);
            }
        }
        return newLine.toString();
    }

    private static void appendPotentialNumberAsString(String line, int i, StringBuilder newLine) {
        StringBuilder potentialNumberAsString = new StringBuilder();
        potentialNumberAsString.append(line.charAt(i));
        for (int j = i +1; j < line.length() && j < i +5; j++) {
            potentialNumberAsString.append(line.charAt(j));
            if (NumberAsLetter.getValuesAsLowercase().contains(potentialNumberAsString.toString())) {
                newLine.append(NumberAsLetter.valueOf(potentialNumberAsString.toString().toUpperCase()).getIntValue());
                break;
            }
        }
    }
}
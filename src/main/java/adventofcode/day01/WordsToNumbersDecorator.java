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
        String newLine = "";
        StringBuilder potentialNumberAsString = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                newLine += line.charAt(i);
            } else {
                potentialNumberAsString.append(line.charAt(i));
                for (int j = i+1; j < line.length() && j < i+5; j++) {
                    potentialNumberAsString.append(line.charAt(j));
                    if (NumberAsLetter.getValuesAsLowercase().contains(potentialNumberAsString.toString())) {
                        newLine += NumberAsLetter.valueOf(potentialNumberAsString.toString().toUpperCase()).getIntValue();
                        break;
                    }
                }
                potentialNumberAsString = new StringBuilder();
            }
        }
        return newLine;
    }
}
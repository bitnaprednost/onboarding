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
        for (NumberAsLetter numberAsLetter : NumberAsLetter.values()) {
            line = line.replaceAll(numberAsLetter.toString(), Integer.toString(numberAsLetter.getIntValue()));
        }
        return line;
    }
}
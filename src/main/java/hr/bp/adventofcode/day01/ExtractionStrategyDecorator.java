package hr.bp.adventofcode.day01;

/**
 * @author Ivan Tomičić
 */
public class ExtractionStrategyDecorator implements CalibrationValueExtractionStrategy {
    protected final CalibrationValueExtractionStrategy strategy;

    public ExtractionStrategyDecorator(CalibrationValueExtractionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int extractCalibrationValueFromLine(String line) {
        return strategy.extractCalibrationValueFromLine(line);
    }
}
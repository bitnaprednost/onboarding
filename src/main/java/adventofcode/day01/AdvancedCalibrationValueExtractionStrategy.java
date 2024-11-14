package adventofcode.day01;

public class AdvancedCalibrationValueExtractionStrategy implements CalibrationValueExtractionStrategy {

    @Override
    public int extractCalibrationValueFromLine(String line) {
        for (NumberAsLetter numberAsLetter : NumberAsLetter.values()) {
            line = line.replaceAll(numberAsLetter.toString(), Integer.toString(numberAsLetter.getIntValue()));
        }

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

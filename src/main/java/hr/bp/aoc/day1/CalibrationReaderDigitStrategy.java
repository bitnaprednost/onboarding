package hr.bp.aoc.day1;

public class CalibrationReaderDigitStrategy implements ReadingStrategy{
    @Override
    public int parseDocument(String document) {
        int firstDigit = findFirstDigit(document);;
        int lastDigit = findLastDigit(document);

        return firstDigit * 10 + lastDigit;
    }

    private static int findLastDigit(String document) {
        for (int i = document.length()-1; i >= 0; i--) {
            char character = document.charAt(i);
            if(Character.isDigit(character)) {
                return Character.getNumericValue(character);
            }
        }
        return -1;
    }

    private int findFirstDigit(String document) {
        for (int i = 0; i < document.length(); i++) {
            char character = document.charAt(i);
            if(Character.isDigit(character)) {
                return Character.getNumericValue(character);
            }
        }
        return -1;
    }

}

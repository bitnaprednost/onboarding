package hr.bp.aoc.day1;

import java.util.List;

public class CalibrationReaderStrategy implements ReadingStrategy{
    @Override
    public int parseDocument(String document) {
        int firstDigit = 0;
        int lastDigit = 0;

        // find first numeric digit
        for (int i = 0; i < document.length(); i++) {
            char character = document.charAt(i);
            if(Character.isDigit(character)) {
                firstDigit = Character.getNumericValue(character);
                break;
            }
        }

        //find last numeric digit
        for (int i = document.length()-1; i >= 0; i--) {
            char character = document.charAt(i);
            if(Character.isDigit(character)) {
                lastDigit = Character.getNumericValue(character);
                break;
            }
        }

        return firstDigit * 10 + lastDigit;
    }

}

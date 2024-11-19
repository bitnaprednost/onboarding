package hr.bp.aoc.day1;

public class CalibrationReaderDigitAndStringStrategy implements ReadingStrategy{
    @Override
    public int parseDocument(String line) {
        int firstDigit = findFirstDigit(line);
        int lastDigit = findLastDigit(line);

        return firstDigit * 10 + lastDigit;
    }

    private int findFirstDigit(String line) {
        char[] charArray = line.toCharArray();

        StringBuilder foundDigitString = new StringBuilder();
        int foundDigit = -1;

        for (char c : charArray) {
            if (Character.isDigit(c)) {
                foundDigit = Character.getNumericValue(c);
                break;
            }
            foundDigitString.append(c);
            int isDigitString = isDigitString(foundDigitString.toString());
            if (isDigitString > 0) {
                foundDigit = isDigitString;
                break;
            }
        }

        return foundDigit;
    }

    private int findLastDigit(String line) {
        char[] charArray = line.toCharArray();

        StringBuilder foundDigitString = new StringBuilder();
        int foundDigit = -1;

        for (int i = charArray.length-1; i >= 0; i--) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                foundDigit = Character.getNumericValue(c);
                break;
            }
            foundDigitString.append(c);
            int isDigitString = isDigitString(foundDigitString.reverse().toString());
            if (isDigitString > 0) {
                foundDigit = isDigitString;
                break;
            }
            foundDigitString.reverse();
        }
        return foundDigit;
    }

    private int isDigitString(String digitString) {
        for (DigitsToWordsEnum digitStringEnum : DigitsToWordsEnum.values()) {
            if (digitString.contains(digitStringEnum.toString())) {
                return digitStringEnum.getIntValue();
            }
        }
        return -1;
    }

}

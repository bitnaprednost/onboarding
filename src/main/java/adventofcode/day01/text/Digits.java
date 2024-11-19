package adventofcode.day01.text;

import java.util.Arrays;
import java.util.List;

public enum Digits {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    NOT_A_NUMBER(Integer.MIN_VALUE);

    private final int intValue;

    Digits(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static List<String> getValuesAsLowercase() {
        return Arrays.stream(values()).map(a -> a.name().toLowerCase()).toList();
    }

    public static Digits valueOfString(String value) {
        if (value == null || value.isEmpty()) {
            return NOT_A_NUMBER;
        }

        for (Digits digit : Digits.values()) {
            if (value.equalsIgnoreCase(digit.name())) {
                return digit;
            }
        }

        return NOT_A_NUMBER;
    }

}

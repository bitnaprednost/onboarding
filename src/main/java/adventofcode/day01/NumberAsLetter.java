package adventofcode.day01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum NumberAsLetter {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int intValue;

    NumberAsLetter(int intValue) {
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

}

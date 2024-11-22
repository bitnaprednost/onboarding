package adventofcode.day01.text;

/**
 * @author Ivan Tomičić
 */
public enum Digit {

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

    Digit(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static Digit valueOfString(String value) {
        if (value == null || value.isEmpty()) {
            return NOT_A_NUMBER;
        }

        for (Digit digit : Digit.values()) {
            if (value.equalsIgnoreCase(digit.name())) {
                return digit;
            }
        }

        return NOT_A_NUMBER;
    }

}

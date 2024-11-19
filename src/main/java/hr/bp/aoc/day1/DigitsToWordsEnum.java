package hr.bp.aoc.day1;

public enum DigitsToWordsEnum {
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

    private DigitsToWordsEnum(final int intValue) {this.intValue = intValue;}

    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}

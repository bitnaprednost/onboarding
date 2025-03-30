package hr.bp.aoc2024.day11;

import java.util.Objects;

public class Stone {
    private long number;

    public Stone(long number) {
        this.number = number;
    }

    public Stone blink() {
        if (number == 0) {
            engraveOne();
            return null;
        }
        if (ifNumberEvenDigits()) {
            return splitStoneInTwo();
        }
        multiplyBy2024();
        return null;
    }

    private void engraveOne() {
        number = 1;
    }

    private boolean ifNumberEvenDigits() {
        return Long.toString(number).length() % 2 == 0;
    }

    private Stone splitStoneInTwo() {
        long rightNumber = getRightDigitsOfNumber(Long.toString(number));

        Stone rightStone = new Stone(rightNumber);
        number = getLeftDigitsOfNumber(Long.toString(number));

        return rightStone;
    }

    private long getLeftDigitsOfNumber(String numberString) {
        return Long.parseLong(numberString.substring(0, numberString.length() / 2));
    }

    private long getRightDigitsOfNumber(String numberString) {
        return Long.parseLong(numberString.substring(numberString.length() / 2));
    }

    private void multiplyBy2024() {
        number = number * 2024;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Stone stone = (Stone) o;
        return number == stone.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return " Stone "
                + number;
    }
}

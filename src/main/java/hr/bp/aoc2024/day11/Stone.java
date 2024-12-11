package hr.bp.aoc2024.day11;

import java.util.List;

public class Stone {
    private long number;

    public Stone(long number) {
        this.number = number;
    }

    public List<Stone> blink() {
        if (number == 0) {
            engraveOne();
            return List.of(this);
        }
        if (ifNumberEvenDigits()) {
            return List.of(this, splitStoneInTwo());
        }
        multiplyBy2024();
        return List.of(this);
    }

    private void engraveOne() {
        number = 1;
    }

    private boolean ifNumberEvenDigits() {
        return Long.toString(number).split("").length % 2 == 0;
    }

    private Stone splitStoneInTwo() {
        long rightNumber = getRightDigitsOfNumber();

        Stone rightStone = new Stone(rightNumber);
        number = getLeftDigitsOfNumber();

        return rightStone;
    }

    private long getRightDigitsOfNumber() {
        int length = (int) Math.log10(number) + 1;
        long divisor = (long) Math.pow(10, length / 2);
        return number % divisor;
    }

    private long getLeftDigitsOfNumber() {
        int length = (int) Math.log10(number) + 1;
        long divisor = (long) Math.pow(10, length / 2);
        return number / divisor;
    }

    private void multiplyBy2024() {
        number = number * 2024;
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
    public String toString() {
        return "Stone "
                 + number;
    }
}

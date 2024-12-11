package hr.bp.aoc2024.day11;

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
        return " Stone "
                + number;
    }
}

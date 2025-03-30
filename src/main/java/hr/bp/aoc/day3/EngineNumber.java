package hr.bp.aoc.day3;

import java.util.Objects;

public class EngineNumber {
    private int start;
    private int end;
    private int row;
    private int value;

    public EngineNumber(int start, int end, int value, int row) {
        this.start = start;
        this.end = end;
        this.value = value;
        this.row = row;
    }

    @Override
    public String toString() {
        return "EngineNumber{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EngineNumber that = (EngineNumber) o;
        return start == that.start && end == that.end && value == that.value && row == that.row;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, row, value);
    }
}

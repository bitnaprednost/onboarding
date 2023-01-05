package hr.bp.aoc.day3;

public abstract class BasePriorityCounter {

    protected abstract char getCommonChar();
    public int getCharPriority() {
        char c = this.getCommonChar();
        if (c >= 'a' && c <= 'z') {
            return ((int) c - (int) ('a') + 1);
        } else if (c >= 'A' && c <= 'Z') {
            return ((int) c - (int) ('A') + 1 + 26);
        }
        return 0;
    }
}

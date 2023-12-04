package hr.bp.aoc.days.calorieCounting.model;

/**
 * @author Luka Ljubić
 */
public class Elf implements Comparable<Elf> {

    private int callorieCount;

    public Elf(int callorieCount) {
        this.callorieCount = callorieCount;
    }
    public Elf(){

    }

    public int getCallorieCount() {
        return callorieCount;
    }


    @Override
    public String toString() {
        return "Elf{" +
                "callorieCount=" + callorieCount +
                '}';
    }


    @Override
    public int compareTo(Elf o) {
        return this.callorieCount - o.callorieCount;
    }
}

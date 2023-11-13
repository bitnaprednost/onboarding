package org.example.days.model;

import java.util.ArrayList;
import java.util.List;

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

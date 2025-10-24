package com.bp.aoc.day1;

import java.util.Comparator;
import java.util.List;

/**
 * @author Monika Kušter
 */
public class ElfCaloriesAnalyzer {

    private final List<Elf> elves;

    public ElfCaloriesAnalyzer(List<Elf> elves) {
        this.elves = elves;
    }

    public Elf getMaximumCaloriesElf() {
        Elf maximumCaloriesElf = elves.get(0);

        for (Elf elf : elves) {
            if (elf.numberOfCalories() >= maximumCaloriesElf.numberOfCalories()) {
                maximumCaloriesElf = elf;
            }
        }

        return maximumCaloriesElf;
    }

    public List<Elf> getTopThreeElves() {
        elves.sort(Comparator.comparingInt(Elf::numberOfCalories).reversed());

        return elves.subList(0, 3);
    }

}

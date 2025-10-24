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
        return elves.stream()
                .max(Comparator.comparingInt(Elf::numberOfCalories))
                .orElseThrow(() -> new IllegalStateException("No elves available."));
    }

    public List<Elf> getTopThreeElves() {
        return elves.stream()
                .sorted(Comparator.comparingInt(Elf::numberOfCalories).reversed())
                .limit(3)
                .toList();
    }

}

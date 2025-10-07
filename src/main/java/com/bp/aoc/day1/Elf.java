package com.bp.aoc.day1;

public record Elf(int position, int numberOfCalories) {
    @Override
    public String toString() {
        return
                "Elf #" + position + " with " + numberOfCalories + " calories ";
    }
}

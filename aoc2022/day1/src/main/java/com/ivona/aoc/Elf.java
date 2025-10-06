package com.ivona.aoc;

public record Elf(int position, int numberOfCalories) {
    @Override
    public String toString() {
        return
                "Elf #" + position + " with " + numberOfCalories + " calories ";
    }
}

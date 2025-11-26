package com.bp.aoc.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ElfCaloriesLoaderTest {

    @Test
    void testLoaderWithBasicFile () {
        List<Elf> elves = ElfCaloriesLoader.loadElves("day1_test.txt");

        assertEquals(5, elves.size());

        assertEquals(6000, elves.get(0).numberOfCalories());
        assertEquals(4000, elves.get(1).numberOfCalories());
        assertEquals(11000, elves.get(2).numberOfCalories());
        assertEquals(24000, elves.get(3).numberOfCalories());
        assertEquals(10000, elves.get(4).numberOfCalories());
    }

    @Test
    void testLoaderWithInvalidLineFile () {
        assertThrows(RuntimeException.class, () ->
                ElfCaloriesLoader.loadElves("day1_invalid.txt")
        );
    }

    @Test
    void testLoaderWithNonExistingFile () {
        assertThrows(RuntimeException.class, () ->
                ElfCaloriesLoader.loadElves("nonExistingFile.txt")
        );
    }
}
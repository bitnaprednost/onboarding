package com.bp.aoc.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElfCaloriesAnalyzerTest {

    static Stream<TestCase> elfListProvider() {
        return Stream.of(
                new TestCase(
                        List.of(new Elf(1, 10000), new Elf(2, 11000), new Elf(3, 24000)),
                        List.of(24000, 11000, 10000)
                ),
                new TestCase(
                        List.of(new Elf(1,10000), new Elf(2, 11000)),
                        List.of(11000, 10000)
                ),
                new TestCase(
                        List.of(),
                        List.of()
                ),
                new TestCase(
                        List.of(new Elf(1,10000), new Elf(2,10000), new Elf(3,10000)),
                        List.of(10000, 10000, 10000)
                ),
                new TestCase(
                        List.of(new Elf(1, 24000), new Elf(2, 11000), new Elf(3,24000)),
                        List.of(24000, 24000, 11000)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("elfListProvider")
    void testTopThreeElves(TestCase testCase) {
        ElfCaloriesAnalyzer analyzer = new ElfCaloriesAnalyzer(testCase.elves);

        List<Elf> top3 = analyzer.getTopThreeElves();

        assertEquals(testCase.expectedCalories.size(), top3.size(), "Size of top elves does not match");
        for (int i = 0; i < top3.size(); i++) {
            assertEquals(testCase.expectedCalories.get(i), top3.get(i).numberOfCalories());
        }
    }

    static class TestCase {
        List<Elf> elves;
        List<Integer> expectedCalories;

        TestCase(List<Elf> elves, List<Integer> expectedCalories) {
            this.elves = elves;
            this.expectedCalories = expectedCalories;
        }
    }


    @Test
    void testGetMaximumCaloriesElf() {
        List<Elf> elves = new ArrayList<>(List.of(
                new Elf(1, 10000),
                new Elf(2, 11000),
                new Elf(3, 24000)
        ));
        ElfCaloriesAnalyzer analyzer = new ElfCaloriesAnalyzer(elves);
        assertEquals(24000, analyzer.getMaximumCaloriesElf().numberOfCalories());
    }

    @Test
    void testGetMaximumCaloriesElfFromEmptyListThrows() {
        List<Elf> elves = new ArrayList<>();
        ElfCaloriesAnalyzer analyzer = new ElfCaloriesAnalyzer(elves);

        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalStateException.class,
                analyzer::getMaximumCaloriesElf
        );
    }

    @Test
    void testGetMaximumCaloriesElfFromListWithOneElf() {
        List<Elf> elves = new ArrayList<>(List.of(
                new Elf(1, 10000)
        ));
        ElfCaloriesAnalyzer analyzer = new ElfCaloriesAnalyzer(elves);
        assertEquals(10000, analyzer.getMaximumCaloriesElf().numberOfCalories());
    }
}
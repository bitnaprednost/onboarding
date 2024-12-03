package hr.bp.aoc2024.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc2024.day2.TestUtil.getFinalInput;
import static hr.bp.aoc2024.day2.TestUtil.getTestInput;

class NuclearPlantTest {

    @Test
    void getNumOfSafeReports_testInput() {
        ReportsParser parser = new ReportsParser(List.of(getTestInput().split("\\n")));

        NuclearPlant nuclearPlant = new NuclearPlant(parser.parseInput());

        long expectedNumOfSafeReports = 2;

        Assertions.assertEquals(expectedNumOfSafeReports, nuclearPlant.getNumOfSafeReports());
    }

    @Test
    void getNumOfSafeReports_FinalInput() {
        ReportsParser parser = new ReportsParser(List.of(getFinalInput().split("\\n")));

        NuclearPlant nuclearPlant = new NuclearPlant(parser.parseInput());

        long expectedNumOfSafeReports = 383;

        Assertions.assertEquals(expectedNumOfSafeReports, nuclearPlant.getNumOfSafeReports());
    }

    @Test
    void ProblemDampener_numSafeReports_testInput() {
        ReportsParser parser = new ReportsParser(List.of(getTestInput().split("\\n")));

        NuclearPlant nuclearPlant = new NuclearPlant(parser.parseInput(), true);

        long expectedNumOfSafeReports = 4;

        Assertions.assertEquals(expectedNumOfSafeReports, nuclearPlant.getNumOfSafeReports());
    }
}
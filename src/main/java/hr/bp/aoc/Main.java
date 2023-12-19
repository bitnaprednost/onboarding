package hr.bp.aoc;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.days.campCleanup.DayFour;
import hr.bp.aoc.days.noSpaceLeftOnDevice.DaySeven;
import hr.bp.aoc.days.ropeBridge.DayNine;
import hr.bp.aoc.days.supplyStacks.DayFive;
import hr.bp.aoc.days.treetopTreeHouse.DayEight;
import hr.bp.aoc.days.tuningTrouble.DaySix;
import hr.bp.aoc.model.Day;
import hr.bp.aoc.days.rucksackReorganization.DayThree;

/**
 * @author Luka Ljubić
 */
public class Main {
    public static void main(String[] args) {
		for (Day day : days) {
			day.executePartOne();
			day.executePartTwo();
		}
    }

	private static Day[] days = new Day[] {
		new DayNine()
	};
}
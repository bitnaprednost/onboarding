package hr.bitnaprednost;

import hr.bitnaprednost.days.D01_CalorieCounting.DayOne;
import hr.bitnaprednost.days.D02_RockPaperScissors.DayTwo;
import hr.bitnaprednost.days.model.Day;

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
		new DayOne(), new DayTwo()
	};
}
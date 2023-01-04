package hr.bp.aoc.day1;

import java.util.Collections;
import java.util.List;

public class ThreeElvesCalorieCounterImpl extends BaseCalorieCounter {

	@Override
	public int getCalories(List<String> lines) {
		List<Integer> sumGroups = totalCaloriesCarriedByEachElf(lines);

		sumGroups.sort(Collections.reverseOrder());

		return sumGroups.get(0) + sumGroups.get(1) + sumGroups.get(2);
	}

	@Override
	public String getNumberOfElvesLabel() {
		return "Three elves";
	}

}

package hr.bp.aoc.day1;

import java.util.List;

public class TotalCalorieCounterImpl extends BaseCalorieCounter {

	@Override
	public int getCalories(List<String> lines) {
		List<Integer> sumGroups = totalCaloriesCarriedByEachElf(lines);

		int maxCalories = 0;

		for (Integer sumGroup : sumGroups) {
			if (maxCalories < sumGroup) {
				maxCalories = sumGroup;
			}
		}

		return maxCalories;
	}

	@Override
	public String getNumberOfElvesLabel() {
		return "Top elf is";
	}

}
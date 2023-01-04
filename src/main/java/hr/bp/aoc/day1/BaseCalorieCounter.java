package hr.bp.aoc.day1;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCalorieCounter implements CalorieCounter {

	protected List<Integer> totalCaloriesCarriedByEachElf(List<String> lines) {
		int sumCalories = 0;
		List<Integer> sumGroups = new ArrayList<>();
		for (String line : lines) {
			if (line.isBlank()) {
				sumGroups.add(sumCalories);
				sumCalories = 0;
				continue;
			}
			sumCalories += Integer.parseInt(line);
		}
		sumGroups.add(sumCalories);
		return sumGroups;
	}

}

package hr.bp.aoc.day1;

import hr.bp.aoc.InputUtil;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.out.println("Missing part id argument... please pass [1] for part 1 or [2] for part 2");

			System.exit(1);

			return;
		}

		int part = validatePart(Integer.parseInt(args[0]));

		Path inputFilePath = InputUtil.getPath(CalorieCounting.class, "inputday1.txt");

        List<String> lines = new ArrayList<>();

		Path filePath = inputFilePath.toAbsolutePath();

		Collections.addAll(lines, InputUtil.readLines(filePath.toString()));

        List<Integer> sumGroups = totalCaloriesCarriedByEachElf(lines);

		if (part == 1) {
			int maxCalories = maxCaloriesCarrying(sumGroups);
			System.out.println("Elf is carrying " + maxCalories + " calories.");

			System.exit(1);
			return;
		}

        int sumOfTopThreeElves = sumOfThreeElves(sumGroups);
        System.out.println("Top three Elves are carrying " + sumOfTopThreeElves + " calories");

		System.exit(1);
    }

	private static int validatePart(int part) {
		if ((part < 1) || (part > 2)) {
			throw new IllegalArgumentException("Part should be 1 or 2");
		}

		return part;
	}

    private static List<Integer> totalCaloriesCarriedByEachElf(List<String> lines) {
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

    private static int maxCaloriesCarrying(List<Integer> sumGroups) {
        int maxCalories = 0;
        for (Integer sumGroup : sumGroups) {
            if (maxCalories < sumGroup) {
                maxCalories = sumGroup;
            }
        }
        return maxCalories;
    }

    private static int sumOfThreeElves(List<Integer> sumGroups) {
        sumGroups.sort(Collections.reverseOrder());
        return sumGroups.get(0) + sumGroups.get(1) + sumGroups.get(2);
    }
}
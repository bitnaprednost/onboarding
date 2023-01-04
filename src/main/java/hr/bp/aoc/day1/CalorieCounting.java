package hr.bp.aoc.day1;

import hr.bp.aoc.InputUtil;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
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

		Path filePath = inputFilePath.toAbsolutePath();


		CalorieCounting calorieCounting = new CalorieCounting();

		if (part == 1) {
			System.out.printf(
				"Elf is carrying %d calories.\n",
				calorieCounting.maxCaloriesCarrying(
					Arrays.asList(InputUtil.readLines(filePath.toString()))));

			System.exit(1);
			return;
		}

        System.out.printf(
			"Top three Elves are carrying %d calories\n",
			calorieCounting.sumOfThreeElves(
				Arrays.asList(InputUtil.readLines(filePath.toString()))));

		System.exit(1);
    }

	private static int validatePart(int part) {
		if ((part < 1) || (part > 2)) {
			throw new IllegalArgumentException("Part should be 1 or 2");
		}

		return part;
	}

    private List<Integer> totalCaloriesCarriedByEachElf(List<String> lines) {
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

    private int maxCaloriesCarrying(List<String> lines) {
		List<Integer> sumGroups = totalCaloriesCarriedByEachElf(lines);

        int maxCalories = 0;

		for (Integer sumGroup : sumGroups) {
            if (maxCalories < sumGroup) {
                maxCalories = sumGroup;
            }
        }

        return maxCalories;
    }

    private int sumOfThreeElves(List<String> lines) {
		List<Integer> sumGroups = totalCaloriesCarriedByEachElf(lines);

        sumGroups.sort(Collections.reverseOrder());

		return sumGroups.get(0) + sumGroups.get(1) + sumGroups.get(2);
    }
}
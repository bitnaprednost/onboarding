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

		CalorieCounter calorieCounter = getCalorieCounter(Integer.parseInt(args[0]));

		Path inputFilePath = InputUtil.getPath(CalorieCounting.class, "inputday1.txt");

		Path filePath = inputFilePath.toAbsolutePath();

		int calories = calorieCounter.getCalories(Arrays.asList(InputUtil.readLines(filePath.toString())));

        System.out.printf(
			"%s carry %d calories\n", calorieCounter.getNumberOfElvesLabel(), calories);

		System.exit(1);
    }

	private static CalorieCounter getCalorieCounter(int metodology) {
		if (metodology == 1) {
			return new TotalCalorieCounterImpl();
		} else if (metodology == 2) {
			return new ThreeElvesCalorieCounterImpl();
		}

		throw new IllegalArgumentException("Part should be 1 or 2");
	}

}
package hr.bp.aoc.calorie.counting;

import hr.bp.aoc.calorie.counting.visitor.ElfVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.Validate;

/**
 * <p>ElfManager class.</p>
 *
 * @author Marko Krišković
 */
public class ElfManager {

	private ElfManager() {
	}

	private static String validate(String calorie) {
		Validate.notNull(calorie, "String input is null.");
		calorie = calorie.replaceAll("[^\\d-\\n]", "");
		Validate.notEmpty(calorie, "Input is empty after filtering. Input is probably invalid."); //throws IllegalArgumentException, not customizable?

		return calorie;
	}

	public static Elf createElf(String calorie) {
		calorie = validate(calorie);

		ElfBuilder elfBuilder = new ElfBuilder();
		Arrays.stream(
			calorie.split("\n")
		).mapToInt(
			Integer::parseInt
		).forEach(
			elfBuilder::append
		);

		return elfBuilder.build();
	}

	public static List<Elf> createElves(String calories) {
		String[] split = calories.split("\n\n");

		List<Elf> elves = new ArrayList<>();

		for (String calorieString : split) {
			elves.add(createElf(calorieString));
		}

		return elves;
	}

	public static List<Elf> getElfMostCalories(List<Elf> elves, int N) {
		return elves.stream(
		).sorted(
			Comparator.comparing(
				Elf::getCalories
			).reversed()
		).limit(
			N
		).toList();
	}

	public static Elf getElfMostCalories(List<Elf> elves) {
		return getElfMostCalories(
			elves, 1
		).iterator(
		).next();
	}

	public static int sumCalories(List<Elf> topElves) {
		ElfVisitor visitor = new ElfVisitor();

		for (Elf topElf : topElves) {
			topElf.accept(visitor);
		}

		return visitor.getSum();
	}

}
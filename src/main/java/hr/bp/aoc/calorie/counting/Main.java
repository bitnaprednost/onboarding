package hr.bp.aoc.calorie.counting;

import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import java.nio.file.Path;
import java.util.List;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) throws IOException {
		Path path = Path.of("src/main/resources/day1Data.txt");
		String text = Reader.getTextFromFile(path);
		List<Elf> elves = ElfManager.createElves(text);

		Elf elfMostCalories = ElfManager.getElfMostCalories(elves);
		int result1 = elfMostCalories.getCalories();
		logger.info(String.valueOf(result1));

		List<Elf> elvesMostCalories = ElfManager.getElfMostCalories(elves, 3);
		int result2 = ElfManager.sumCalories(elvesMostCalories);
		logger.info(String.valueOf(result2));
	}

}
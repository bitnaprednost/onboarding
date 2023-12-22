package hr.bp.aoc.monkeyInTheMiddle;

import hr.bp.aoc.monkeyInTheMiddle.monkey.Monkey;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyManager;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyParser;
import hr.bp.aoc.util.Reader;

import java.io.IOException;
import java.nio.file.Path;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Path path = Path.of("src/main/resources/day11Data.txt");
		String textFromFile = Reader.getTextFromFile(path);

		Monkey[] monkeyList = MonkeyParser.parseToMonkies(textFromFile);
		MonkeyManager monkeyManager = MonkeyManager.of(monkeyList);
		//monkeyManager.simulateRounds(20);
		monkeyManager.simulateRoundsNoRelief(10000);

		Long result = monkeyManager.getProductOfTopActiveMonkeys(2);
		System.out.println(result);
	}

}
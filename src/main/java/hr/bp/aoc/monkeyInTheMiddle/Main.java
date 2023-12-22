package hr.bp.aoc.monkeyInTheMiddle;

import hr.bp.aoc.monkeyInTheMiddle.monkey.Monkey;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyManager;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyParser;
import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws IOException {
		Path path = Path.of("src/main/resources/day11Data.txt");
		String textFromFile = Reader.getTextFromFile(path);

		Monkey[] monkeyList = MonkeyParser.parseToMonkies(textFromFile);
		MonkeyManager monkeyManager = MonkeyManager.of(monkeyList);
		//monkeyManager.simulateRounds(20);
		monkeyManager.simulateRoundsNoRelief(10000);

		Long result = monkeyManager.getProductOfTopActiveMonkeys(2);
		logger.info(String.valueOf(result));
	}

}
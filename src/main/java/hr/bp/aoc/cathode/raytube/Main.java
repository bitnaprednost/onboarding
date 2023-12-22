package hr.bp.aoc.cathode.raytube;

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
		Path path = Path.of("src/main/resources/day10Data.txt");
		String[] textFromFile = Reader.getLinesFromFile(path);

		RayTube rayTube = new RayTube();

		for (String line : textFromFile) {
			rayTube.parse(line);
		}

		int result = rayTube.getSignalSum();
		logger.info(String.valueOf(result));
		rayTube.printMessage();
	}

}
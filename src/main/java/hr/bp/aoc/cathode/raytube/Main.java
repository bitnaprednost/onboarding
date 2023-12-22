package hr.bp.aoc.cathode.raytube;

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
		Path path = Path.of("src/main/resources/day10Data.txt");
		String[] textFromFile = Reader.getLinesFromFile(path);

		RayTube rayTube = new RayTube();

		for (String line : textFromFile) {
			rayTube.parse(line);
		}

		int result = rayTube.getSignalSum();
		System.out.println(result);
		rayTube.printMessage();
	}

}
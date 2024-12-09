package aoc_2024.day8;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day8/AntennaMap.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        AntennaMap map = new AntennaMap();
        int result = map.calculateUniqueLocations(fileContent);

        logger.debug("Number of unique antinode location is: {}", result);

        ResonantHarmonics harmonics = new ResonantHarmonics();
        result = harmonics.calculateUniqueLocations(fileContent);

        logger.debug("Number of unique antinode location with resonant harmonics is: {}", result);

    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}

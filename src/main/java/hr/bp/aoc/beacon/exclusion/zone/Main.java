package hr.bp.aoc.beacon.exclusion.zone;

import hr.bp.aoc.beacon.exclusion.zone.zone.Zone;
import hr.bp.aoc.beacon.exclusion.zone.zone.ZoneParser;
import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day15Data.txt");
        String[] lines = Reader.getLinesFromFile(path);

        Zone zone = ZoneParser.createZone(lines);
        zone.calculateOccupiedPositions(2000000);
        int count = zone.getOccupiedSize();

        logger.info(String.valueOf(count));


        Beacon beacon = zone.findBeaconWithLines(4000000);
        long frequency = beacon.calculateFrequency();

        logger.info(String.valueOf(frequency));
    }
}

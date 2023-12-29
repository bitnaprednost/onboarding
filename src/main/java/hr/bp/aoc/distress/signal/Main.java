package hr.bp.aoc.distress.signal;

import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day13Data.txt");
        String textFromFile = Reader.getTextFromFile(path);

        List<Object[]> signals = SignalParser.stringToCommands(textFromFile);
        int sum = SignalParser.sumCorrectSignals(signals);

        logger.info(String.valueOf(sum));
    }
}

package hr.bp.aoc.noSpaceLeftOnDevice;

import hr.bp.aoc.noSpaceLeftOnDevice.file.Directory;
import hr.bp.aoc.noSpaceLeftOnDevice.file.FileSystem;
import jdk.jshell.spi.ExecutionControl;
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
    public static void main(String[] args) throws IOException, ExecutionControl.NotImplementedException {
        Path path = Path.of("src/main/resources/day7Data.txt");
        String[] textFromFile = Reader.getLinesFromFile(path);

        FileSystem fileSystem = ReaderDay7.createFileSystem(textFromFile, 70000000);
        long size = fileSystem.sumDirectoriesWithMaxSizeOf(100000);
        logger.info(String.valueOf(size));

        Directory minDirectory = fileSystem.findMinDirectory(30000000);
        logger.info(minDirectory.getName());
        logger.info(String.valueOf(minDirectory.getSize()));
    }
}

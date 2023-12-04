package hr.bp.aoc.noSpaceLeftOnDevice.file;

/**
 * <p>File interface.</p>
 *
 * @author Marko Krišković
 */
public interface File extends Comparable<File>{
    String getName();
    String getType();
    long getSize();
}

package hr.bp.aoc.noSpaceLeftOnDevice.file;

public interface File extends Comparable<File>{
    String getName();
    String getType();
    long getSize();
}

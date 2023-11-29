package hr.bitnaPrednost.day7.file;

public interface File extends Comparable<File>{
    String getName();
    String getType();
    long getSize();
}

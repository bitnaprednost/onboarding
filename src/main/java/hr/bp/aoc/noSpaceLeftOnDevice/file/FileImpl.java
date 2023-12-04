package hr.bp.aoc.noSpaceLeftOnDevice.file;

/**
 * <p>FileImpl class.</p>
 *
 * @author Marko Krišković
 */
public class FileImpl implements File {
    private final String name;
    private final long size;
    private static final String TYPE = "file";

    private FileImpl(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public static FileImpl from(String name, long size) {
        return new FileImpl(name ,size);
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileImpl file)) return false;

        return name.equals(file.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(File file) {
        long size1 = getSize();
        long size2 = file.getSize();

        if(size1>size2) return 1;
        else if(size1<size2) return -1;
        else return 0;
    }
}

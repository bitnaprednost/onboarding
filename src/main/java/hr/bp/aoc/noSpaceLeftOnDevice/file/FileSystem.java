package hr.bp.aoc.noSpaceLeftOnDevice.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileSystem {
    private final Directory root;
    private final long distSpace;
    private Directory current;

    public FileSystem(long distSpace) {
        root = Directory.from("/");
        this.distSpace = distSpace;
        current = root;
    }

    public File getFileFromPosition(int i) {
        return current.getFileFromPosition(i);
    }

    public File findFirstDirectory(String fileName) {
        return current.findFirstDirectory(fileName);
    }

    public File findFirstFile(String fileName) {
        return current.findFirstFile(fileName);
    }

    public void addFile(File testFile) {
        current.addFile(testFile);
    }

    public void addFile(Directory to, File file) {
        to.addFile(file);
    }

    public void moveCursorForward(String a) {
        Directory prev = getCurrent();
        current = current.findShallow(a);
        current.setPreviousDirectory(prev);
    }

    public void moveCursorBackward() {
        Optional<Directory> parent = current.getPreviousDirectory();
        if(parent.isPresent()) current = root.findFirstDirectory(parent.get());
    }

    public void resetCursor() {
        current = root;
    }

    public Directory getCurrent(){
        return current.getCurrent();
    }

    public long getSize() {
        return getSize(current);
    }

    public long getSize(Directory from) {
        return from.getSize();
    }

    private List<Directory> getDirectoriesWithMaxSizeOf(long maxSize, Directory directory) {
        List<Directory> list = new ArrayList<>();
        directory.getSizeCriterion(list, maxSize);
        return list;
    }

    protected List<Directory> getDirectoriesWithMaxSizeOf(long maxSize) {
        return getDirectoriesWithMaxSizeOf(maxSize, root);
    }

    public long sumDirectoriesWithMaxSizeOf(long maxSize, Directory directory) {
        List<Directory> list = getDirectoriesWithMaxSizeOf(maxSize, directory);
        return list.stream().mapToLong(Directory::getSize).sum();
    }

    public long sumDirectoriesWithMaxSizeOf(long maxSize) {
        return sumDirectoriesWithMaxSizeOf(maxSize, root);
    }

    public Directory findMinDirectory(long capacity) {
        long leftSpace = distSpace - getSize();
        return root.findMinDirectory(leftSpace, capacity);
    }
}

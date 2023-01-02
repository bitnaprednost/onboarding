package hr.bp.aoc.day7;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File {

    private List<File> files;
    private final Directory parent;

    public Directory(String name, Directory parent) {
        super(name, 0);
        this.parent = parent;
        this.files = new ArrayList<>();
    }

    public Directory getParent() {
        return parent;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public int size() {
        int count = 0;
        for (File file : files) {
            count += file.size();
        }
        return count;
    }

    public Directory getDir(String directoryName) {
        for (File file : files) {
            if (file.getName().equals(directoryName)) {
                return (Directory) file;
            }

        }
        return null;
    }




}

package hr.bp.aoc.day7;

import java.util.ArrayList;

public class Directory extends File {

    private ArrayList<File> files;
    private Directory parent;

    public Directory(String name, Directory parent) {
        super(name, 0);
        this.parent = parent;
        this.files = new ArrayList<File>();
    }

    public Directory getParent() {
        return parent;
    }


    public ArrayList<File> getFiles() {
        return files;
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
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getName().equals(directoryName)) {
                return (Directory) files.get(i);
            }

        }
        return null;
    }




}

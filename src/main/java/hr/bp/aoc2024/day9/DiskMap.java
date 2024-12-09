package hr.bp.aoc2024.day9;

public class DiskMap {
    private int id;
    private int numOfFileSpaces;
    private int numFreeSpace;

    public DiskMap(int id, int numOfFileSpaces, int numFreeSpace) {
        this.id = id;
        this.numOfFileSpaces = numOfFileSpaces;
        this.numFreeSpace = numFreeSpace;
    }

    public int getId() {
        return id;
    }

    public int getNumOfFileSpaces() {
        return numOfFileSpaces;
    }

    public int getNumFreeSpace() {
        return numFreeSpace;
    }
}

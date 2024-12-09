package hr.bp.aoc2024.day9;

import java.util.ArrayList;
import java.util.List;

public class Disk {
    private List<Integer> disk;

    public Disk(DiskParser diskParser) {
        fillDiskFromDiskMaps(diskParser.parseInput());
    }

    public long getFileSystemChecksum() {
        removeFreeSpaceFromDisk();

        long checksum = 0;

        for (int index = 0; index < disk.size(); index++) {
            if (disk.get(index) != -1)
                checksum += (long) index * disk.get(index);
        }

        return checksum;
    }

    private void removeFreeSpaceFromDisk() {

        int indexOfFreeSpace = findFreeSpaceInDiskIndex();
        int indexOfLastFile = findLastFileIndex();

        do {
            switchElementsInDisk(indexOfFreeSpace, indexOfLastFile);

            indexOfFreeSpace = findFreeSpaceInDiskIndex();
            indexOfLastFile = findLastFileIndex();
        } while (indexOfFreeSpace < indexOfLastFile);

    }

    private void switchElementsInDisk(int indexFreeSpace, int indexFile) {
        disk.set(indexFreeSpace, disk.get(indexFile));
        disk.set(indexFile, -1);
    }

    private int findLastFileIndex() {
        for (int i = disk.size() - 1; i >= 0; i--) {
            if (disk.get(i) != -1)
                return i;
        }
        return -1;
    }

    private int findFreeSpaceInDiskIndex() {
        for (int i = 0; i < disk.size(); i++) {
            if (disk.get(i) == -1)
                return i;
        }
        return -1;
    }

    private void fillDiskFromDiskMaps(List<DiskMap> diskMaps) {
        disk = new ArrayList<>();

        for (DiskMap diskMap : diskMaps) {
            addMapToDisk(diskMap);
        }
    }

    private void addMapToDisk(DiskMap diskMap) {
        addFilesToDisk(diskMap);
        addFreeSpaceToDisk(diskMap);
    }

    private void addFilesToDisk(DiskMap diskMap) {
        addToDisk(diskMap.getNumOfFileSpaces(), diskMap.getId());
    }

    private void addFreeSpaceToDisk(DiskMap diskMap) {
        int FREE_SPACE = -1;
        addToDisk(diskMap.getNumFreeSpace(), FREE_SPACE);
    }

    private void addToDisk(int count, int element) {
        for (int i = 0; i < count; i++) {
            disk.add(element);
        }
    }
}

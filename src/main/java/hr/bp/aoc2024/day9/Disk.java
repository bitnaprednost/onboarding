package hr.bp.aoc2024.day9;

import java.util.ArrayList;
import java.util.List;

public class Disk {
    private List<Integer> disk;
    private List<DiskMap> compressedDisk;

    private static final int FREE_SPACE = -1;

    public Disk(DiskParser diskParser) {
        compressedDisk = diskParser.parseInput();
        fillDiskFromDiskMaps(compressedDisk);
    }

    public long getFileSystemChecksum() {
        removeFreeSpaceFromDisk();

        return calculateCheckSum();
    }

    public long getFileSystemChecksum_filesMoved() {
        removeFreeSpaceFromDisk_moveWholeFiles();

        return calculateCheckSum();
    }

    private long calculateCheckSum() {
        long checksum = 0;

        for (int index = 0; index < disk.size(); index++) {
            if (disk.get(index) != FREE_SPACE)
                checksum += (long) index * disk.get(index);
        }

        return checksum;
    }

    private void removeFreeSpaceFromDisk_moveWholeFiles() {
        for (int mapIdToMove = compressedDisk.size()-1; mapIdToMove >= 0; mapIdToMove--){
            moveFiles(compressedDisk.get(mapIdToMove));
        }

    }

    private void moveFiles(DiskMap filesToMove) {
        int indexSearch = 0;
        int indexSearchEnd = getIndexSearchEnd(filesToMove.getId());

        int freeSpaceSize = getFreeSpace(indexSearch);
        int requiredSpace = filesToMove.getNumOfFileSpaces();

        while (requiredSpace > freeSpaceSize && indexSearch < disk.size() && indexSearch < indexSearchEnd) {
            indexSearch++;
            freeSpaceSize = getFreeSpace(indexSearch);
        }

        if(freeSpaceSize >= filesToMove.getNumOfFileSpaces()) {
            moveFilesToEmptySpaces(filesToMove, indexSearch);
        }
    }

    private int getIndexSearchEnd(int id) {
        for (int i = 0; i < disk.size(); i++) {
            if (disk.get(i) == id)
                return i;
        }
        return -1;
    }

    private void moveFilesToEmptySpaces(DiskMap filesToMove, int emptyRangeStart) {
        for (int filesMoved = 0; filesMoved < filesToMove.getNumOfFileSpaces(); filesMoved++) {
            disk.set(emptyRangeStart+filesMoved, filesToMove.getId());
        }
        removeRemovedFilesFromEnd(emptyRangeStart+filesToMove.getNumOfFileSpaces(), filesToMove.getId());
    }

    private void removeRemovedFilesFromEnd(int indexToStartRemoving, int filesToRemove) {
        for (int i = indexToStartRemoving; i < disk.size(); i++) {
            if(disk.get(i) == filesToRemove) {
                disk.set(i, FREE_SPACE);
            }
        }
    }

    private int getFreeSpace(int startIndex) {
        int rangeSize = 0;
        for (int freeSpaceIndex = startIndex; freeSpaceIndex < disk.size(); freeSpaceIndex++) {
            if (disk.get(freeSpaceIndex) == FREE_SPACE) {
                rangeSize++;
            } else break;
        }

        return rangeSize;
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
        disk.set(indexFile, FREE_SPACE);
    }

    private int findLastFileIndex() {
        for (int i = disk.size() - 1; i >= 0; i--) {
            if (disk.get(i) != FREE_SPACE)
                return i;
        }
        return -1;
    }

    private int findFreeSpaceInDiskIndex() {
        for (int i = 0; i < disk.size(); i++) {
            if (disk.get(i) == FREE_SPACE)
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
        addToDisk(diskMap.getNumFreeSpace(), FREE_SPACE);
    }

    private void addToDisk(int count, int element) {
        for (int i = 0; i < count; i++) {
            disk.add(element);
        }
    }
}

package aoc_2024.day9;

import java.util.*;

public class DiskMap {

    private final List<Integer> disk = new ArrayList<>();

    public void parseFilesAndFreeSpace(String diskMap) {
        int idCounter = 0;

        for (int i = 0; i < diskMap.length(); i += 2)
        {
            int fileBlocks = Character.getNumericValue(diskMap.charAt(i));
            int freeBlocks = (i + 1 < diskMap.length()) ? Character.getNumericValue(diskMap.charAt(i + 1)) : 0;

            for (int j = 0; j < fileBlocks; j++)
            {
                disk.add(idCounter);
            }
            for (int j = 0; j < freeBlocks; j++)
            {
                disk.add(-1);
            }

            idCounter++;
        }
    }

    public void moveFileBlocks() {
        int start = disk.size()-1;

        for (int i = 0; i < disk.size(); i++)
        {
            if (disk.get(i) == -1)
            {
                int fileIndex = findLastDigit(start);
                if (fileIndex < i)
                {
                    return;
                }

                disk.set(i, disk.get(fileIndex));
                disk.set(fileIndex, -1);

                start = fileIndex - 1;
            }
        }
    }

    private int findLastDigit(int start) {
        for (int i = start; i >= 0; i--)
        {
            if (disk.get(i) != -1)
            {
                return i;
            }
        }
        return -1;
    }

    public void moveWholeFiles() {

        int maxFileId = disk.getLast();

        for (int fileId = maxFileId; fileId >= 0; fileId--)
        {
            int fileStart = findFileStart(fileId);
            int fileLength = findFileLength(fileId, fileStart);

            int freeSpaceStart = findFreeSpace(fileLength, fileStart);

            if (freeSpaceStart != -1)
            {
                moveFile(fileId, fileStart, fileLength, freeSpaceStart);
            }
        }
    }

    private int findFileStart(int fileId) {
        for (int i = 0; i < disk.size(); i++)
        {
            if (disk.get(i) == fileId)
            {
                return i;
            }
        }
        return -1;
    }

    private int findFileLength(int fileId, int start) {
        int length = 0;
        for (int i = start; i < disk.size(); i++)
        {
            if (disk.get(i) == fileId)
            {
                length++;
            }
        }
        return length;
    }

    private int findFreeSpace(int fileLength, int fileStart) {
        int freeSpaceLength = 0;
        for (int i = 0; i < fileStart; i++)
        {
            if (disk.get(i) == -1)
            {
                freeSpaceLength++;
                if (freeSpaceLength == fileLength)
                {
                    return i - fileLength + 1;
                }
            } else
            {
                freeSpaceLength = 0;
            }
        }
        return -1;
    }

    private void moveFile(int fileId, int fileStart, int fileLength, int freeSpaceStart) {

        for (int i = 0; i < fileLength; i++)
        {
            disk.set(freeSpaceStart + i, fileId);
        }

        for (int i = fileStart; i < fileStart + fileLength; i++)
        {
            disk.set(i, -1);
        }
    }

    public long calculateChecksum() {
        long checksum = 0;

        for (int i = 0; i < disk.size(); i++)
        {
            if (disk.get(i) != -1)
            {
                checksum += (long) i * disk.get(i);
            }
        }

        return checksum;
    }

}

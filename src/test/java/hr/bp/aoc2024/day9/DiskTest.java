package hr.bp.aoc2024.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day9.Util.getFinalInput;
import static hr.bp.aoc2024.day9.Util.getTestInput;

class DiskTest {
    private static Disk disk;

    @Test
    void getFileSystemChecksum_testInput() {
        long expected = 1928;

        DiskParser diskParser = new DiskParser(getTestInput());
        disk = new Disk(diskParser);

        Assertions.assertEquals(expected, disk.getFileSystemChecksum());
    }

    @Test
    void getFileSystemChecksum_finalInput() {
        DiskParser diskParser = new DiskParser(getFinalInput());
        disk = new Disk(diskParser);

        long expectedValue = 6241633730082L;

        Assertions.assertEquals(expectedValue, disk.getFileSystemChecksum());
    }

    @Test
    void getFileSystemChecksum_testInput_wholeFiles() {
        long expected = 2858;

        DiskParser diskParser = new DiskParser(getTestInput());
        disk = new Disk(diskParser);

        Assertions.assertEquals(expected, disk.getFileSystemChecksum_filesMoved());
    }

    @Test
    void getFileSystemChecksum_finalInput_wholeFiles() {
        long expected = 6265268809555L;

        DiskParser diskParser = new DiskParser(getFinalInput());
        disk = new Disk(diskParser);

        Assertions.assertEquals(expected, disk.getFileSystemChecksum_filesMoved());
    }
}
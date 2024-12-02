package aoc_2023.day5;

import java.util.ArrayList;
import java.util.List;

public class Seed {
    private final String seedLine;

    public Seed(String seedsDocument) {
        String[] lines = seedsDocument.split(System.lineSeparator());
        this.seedLine = lines[0];
    }

    // Task 1: Parse seeds into a list of individual seed numbers
    public ArrayList<Long> parseSeeds() {
        String[] parts = seedLine.split(":")[1].trim().split(" ");
        ArrayList<Long> seeds = new ArrayList<>();
        for (String part : parts)
        {
            seeds.add(Long.parseLong(part));
        }
        return seeds;
    }

    // Task 2: Parse seeds into ranges (start and length pairs)
    public List<Range> parseSeedRanges() {
        String[] parts = seedLine.split(":")[1].trim().split(" ");

        List<Range> seedRanges = new ArrayList<>();
        for (int i = 0; i < parts.length; i += 2)
        {
            long start = Long.parseLong(parts[i]);
            long length = Long.parseLong(parts[i + 1]);
            seedRanges.add(new Range(start, start + length));
        }
        return seedRanges;
    }
}

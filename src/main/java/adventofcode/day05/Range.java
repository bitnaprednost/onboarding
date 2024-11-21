package adventofcode.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Ivan Tomičić
 */
public record Range (long start, long end, Function<Long, Long> mappingFunction) {

    public static final Function<Long,Long> DEFAULT_MAPPER = a -> a;
    public static final Comparator<Range> RANGE_COMPARATOR = Comparator.comparingLong(o -> o.start);

    public static List<Range> breakRangeIntoRanges(Range range, List<Range> mapperRanges) {
        List<Range> newRanges = new ArrayList<>();
        List<Range> sortedMapperRanges = new ArrayList<>(List.copyOf(mapperRanges));
        sortedMapperRanges.sort(RANGE_COMPARATOR);

        for (Range mapperRange : sortedMapperRanges) {
            Optional<Range> overlappedRange = getOverlappedRange(range, mapperRange);
            if (overlappedRange.isEmpty()) {
                continue;
            }
            newRanges.add(overlappedRange.get());
        }
        fillBlanks(range.start, range.end, newRanges);
        return newRanges;
    }

    private static void fillBlanks(long start, long end, List<Range> newRanges) {
        List<Range> missingRanges = new ArrayList<>();

        int i = 0;
        if (!newRanges.isEmpty()) {
            while (start < end) {
                Range currentRange = newRanges.get(i);
                if (start >= currentRange.start) {
                    start = currentRange.end + 1;
                    if (++i >= newRanges.size()) {
                        break;
                    }
                } else {
                    missingRanges.add(
                            new Range(start, Math.min(currentRange.start - 1, end), DEFAULT_MAPPER)
                    );
                    start = currentRange.end + 1;
                    if (++i >= newRanges.size()) {
                        break;
                    }
                }
            }
        }
        if (start < end) {
            newRanges.add(new Range(start, end, DEFAULT_MAPPER));
        }
        newRanges.addAll(missingRanges);
        newRanges.sort(RANGE_COMPARATOR);
    }

    public static List<Range> mapToNextLevel(List<Range> currentRanges) {
        List<Range> nextLevelRanges = new ArrayList<>();
        for (Range currentRange : currentRanges) {
            Range nextLevelRange = new Range(
                    currentRange.mappingFunction.apply(currentRange.start),
                    currentRange.mappingFunction.apply(currentRange.end),
                    DEFAULT_MAPPER
            );
            nextLevelRanges.add(nextLevelRange);
        }
        return nextLevelRanges;
    }

    public static Optional<Range> getOverlappedRange(Range seedRange, Range mapperRange) {
        long newStart = Math.max(seedRange.start, mapperRange.start);
        long newEnd = Math.min(seedRange.end, mapperRange.end);
        if (newEnd < newStart) {
            return Optional.empty();
        }
        return Optional.of(new Range(newStart, newEnd, mapperRange.mappingFunction));
    }
}

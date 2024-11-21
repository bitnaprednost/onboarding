package adventofcode.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class AlmanacWithRanges extends Almanac {

    public AlmanacWithRanges(String input) {
        super(input);
    }

    @Override
    public long findLowestLocationNumber() {
        List<Range> seedsRanges = new ArrayList<>();
        for (int i = 0; i < seeds.size(); i += 2) {
            seedsRanges.add(
                    new Range(seeds.get(i), seeds.get(i) + seeds.get(i + 1) - 1, Range.DEFAULT_MAPPER)
            );
        }
        seedsRanges.sort(Range.RANGE_COMPARATOR);

        for (List<SourceDestinationMap> listOfMap : listOfMaps) {
            List<Range> currentLevelRanges = new ArrayList<>();
            for (Range seedRange : seedsRanges) {
                List<Range> mapperRanges = extractMapperRanges(listOfMap);
                List<Range> overlappedRanges = Range.breakRangeIntoRanges(seedRange, mapperRanges);
                currentLevelRanges.addAll(overlappedRanges);
            }
            seedsRanges = Range.mapToNextLevel(currentLevelRanges);
        }

        return seedsRanges
                .stream()
                .mapToLong(Range::start)
                .min().getAsLong();
    }

    private List<Range> extractMapperRanges(List<SourceDestinationMap> sourceDestinationMaps) {
        List<Range> mapperRanges = new ArrayList<>();
        for (SourceDestinationMap map : sourceDestinationMaps) {
            Range mapperRange = new Range(
                    map.sourceStart(),
                    map.sourceStart() + map.rangeLength(),
                    a -> a + map.destinationStart() - map.sourceStart());
            mapperRanges.add(mapperRange);
        }
        return mapperRanges;
    }
}

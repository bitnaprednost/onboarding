package hr.bp.adventofcode.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static hr.bp.adventofcode.day05.Range.DEFAULT_MAPPER;
import static hr.bp.adventofcode.day05.Range.breakRangeIntoRanges;

/**
 * @author Ivan Tomičić
 */
public class RangeTest {

    private static final Function<Long, Long> PLUS_ONE_MAPPER = a -> a + 1;
    private static final Function<Long, Long> PLUS_TWO_MAPPER = a -> a + 2;
    private static final Function<Long, Long> PLUS_THREE_MAPPER = a -> a + 3;

    @Test
    public void breakRangeIntoRanges_givenValidInput_returnsCorrectlyBrokenRanges() {
        Range seedRange = new Range(1,10, DEFAULT_MAPPER);

        List<Range> mapperRanges = List.of(
                new Range(1,2, PLUS_ONE_MAPPER),
                new Range(3,4, PLUS_TWO_MAPPER),
                new Range(8,20, PLUS_THREE_MAPPER)
        );

        List<Range> expectedBrokenRanges = List.of(
                new Range(1, 2, PLUS_ONE_MAPPER),
                new Range(3, 4, PLUS_TWO_MAPPER),
                new Range(5, 7, DEFAULT_MAPPER),
                new Range(8, 10, PLUS_THREE_MAPPER)
        );

        List<Range> actualBrokenRanges = breakRangeIntoRanges(seedRange, mapperRanges);

        Assertions.assertEquals(expectedBrokenRanges, actualBrokenRanges);
    }

    @Test
    public void breakRangeIntoRanges_givenOneFullMapperRange_returnsCorrectlyBrokenRanges() {
        Range seedRange = new Range(10,20, DEFAULT_MAPPER);

        List<Range> mapperRanges = List.of(
                new Range(1,200, PLUS_ONE_MAPPER)
        );

        List<Range> expectedBrokenRanges = List.of(
                new Range(10, 20, PLUS_ONE_MAPPER)
        );

        List<Range> actualBrokenRanges = breakRangeIntoRanges(seedRange, mapperRanges);

        Assertions.assertEquals(expectedBrokenRanges, actualBrokenRanges);
    }

    @Test
    public void breakRangeIntoRanges_givenOneFromBeginningButNotFullMapperRange_returnsCorrectlyBrokenRanges() {
        Range seedRange = new Range(10,20, DEFAULT_MAPPER);

        List<Range> mapperRanges = List.of(
                new Range(1,15, PLUS_ONE_MAPPER)
        );

        List<Range> expectedBrokenRanges = List.of(
                new Range(10, 15, PLUS_ONE_MAPPER),
                new Range(16, 20, DEFAULT_MAPPER)
        );

        List<Range> actualBrokenRanges = breakRangeIntoRanges(seedRange, mapperRanges);

        Assertions.assertEquals(expectedBrokenRanges, actualBrokenRanges);
    }

    @Test
    public void breakRangeIntoRanges_givenOneInTheMiddleMapperRange_returnsCorrectlyBrokenRanges() {
        Range seedRange = new Range(10,20, DEFAULT_MAPPER);

        List<Range> mapperRanges = List.of(
                new Range(12,15, PLUS_ONE_MAPPER)
        );

        List<Range> expectedBrokenRanges = List.of(
                new Range(10, 11, DEFAULT_MAPPER),
                new Range(12, 15, PLUS_ONE_MAPPER),
                new Range(16, 20, DEFAULT_MAPPER)
        );

        List<Range> actualBrokenRanges = breakRangeIntoRanges(seedRange, mapperRanges);

        Assertions.assertEquals(expectedBrokenRanges, actualBrokenRanges);
    }

    @Test
    public void breakRangeIntoRanges_givenOneToTheEndButNotFullMapperRange_returnsCorrectlyBrokenRanges() {
        Range seedRange = new Range(10,20, DEFAULT_MAPPER);

        List<Range> mapperRanges = List.of(
                new Range(15,200, PLUS_ONE_MAPPER)
        );

        List<Range> expectedBrokenRanges = List.of(
                new Range(10, 14, DEFAULT_MAPPER),
                new Range(15, 20, PLUS_ONE_MAPPER)
        );

        List<Range> actualBrokenRanges = breakRangeIntoRanges(seedRange, mapperRanges);

        Assertions.assertEquals(expectedBrokenRanges, actualBrokenRanges);
    }

    @Test
    public void breakRangeIntoRanges_givenNoOverlapMapperRange_returnsCorrectlyBrokenRanges() {
        Range seedRange = new Range(10,20, DEFAULT_MAPPER);

        List<Range> mapperRanges = List.of(
                new Range(1,8, PLUS_ONE_MAPPER),
                new Range(100,800, PLUS_TWO_MAPPER),
                new Range(1_000,8_000, PLUS_THREE_MAPPER),
                new Range(10_000,80_000, PLUS_ONE_MAPPER)
        );

        List<Range> expectedBrokenRanges = List.of(
                new Range(10, 20, DEFAULT_MAPPER)
        );

        List<Range> actualBrokenRanges = breakRangeIntoRanges(seedRange, mapperRanges);

        Assertions.assertEquals(expectedBrokenRanges, actualBrokenRanges);
    }
}

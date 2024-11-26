package hr.bp.adventofcode.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.adventofcode.day05.TestUtils.getInputForTheTask;
import static hr.bp.adventofcode.day05.TestUtils.getInputOne;


/**
 * @author Ivan Tomičić
 */
public class AlmanacTest {

    @Test
    public void constructor_givenValidInput_createsAlmanacWithExpectedValues() {
        String input = getInputOne();

        Almanac almanac = new Almanac(input);

        assertAlmanacOneCreatedCorrectly(almanac);
    }

    @Test
    public void findLowestLocationNumber_givenValidInput_returnsCorrectLowestLocationNumber() {
        String input = getInputOne();
        Almanac almanac = new Almanac(input);

        long expectedLowestLocationNumber = 35;

        long actualLowestLocationNumber = almanac.findLowestLocationNumber();

        Assertions.assertEquals(expectedLowestLocationNumber, actualLowestLocationNumber);
    }

    @Test
    public void findLowestLocationNumber_givenValidInput_returnsCorrectLowestLocationNumberTwo() {
        String input = getInputForTheTask();
        Almanac almanac = new Almanac(input);

        long expectedLowestLocationNumber = 226172555;

        long actualLowestLocationNumber = almanac.findLowestLocationNumber();

        Assertions.assertEquals(expectedLowestLocationNumber, actualLowestLocationNumber);
    }

    @Test
    public void findLowestLocationNumber_givenValidInputTaskTwo_returnsCorrectLowestLocationNumber() {
        String input = getInputOne();
        Almanac almanacWithRanges = new AlmanacWithRanges(input);

        long expectedLowestLocationNumber = 46;

        long actualLowestLocationNumber = almanacWithRanges.findLowestLocationNumber();

        Assertions.assertEquals(expectedLowestLocationNumber, actualLowestLocationNumber);
    }


    private void assertAlmanacOneCreatedCorrectly(Almanac almanac) {
        List<Long> expectedSeeds = List.of(79L, 14L, 55L, 13L);

        List<SourceDestinationMap> expectedSeedToSoilMap = List.of(
                new SourceDestinationMap(50, 98, 2),
                new SourceDestinationMap(52, 50, 48)
        );

        List<SourceDestinationMap> expectedSoilToFertilizerMap = List.of(
                new SourceDestinationMap(0, 15, 37),
                new SourceDestinationMap(37, 52, 2),
                new SourceDestinationMap(39, 0, 15)
        );

        List<SourceDestinationMap> expectedFertilizerToWaterMap = List.of(
                new SourceDestinationMap(49, 53, 8),
                new SourceDestinationMap(0, 11, 42),
                new SourceDestinationMap(42, 0, 7),
                new SourceDestinationMap(57, 7, 4)
        );

        List<SourceDestinationMap> expectedWaterToLightMap = List.of(
                new SourceDestinationMap(88, 18, 7),
                new SourceDestinationMap(18, 25, 70)
        );

        List<SourceDestinationMap> expectedLightToTemperatureMap = List.of(
                new SourceDestinationMap(45, 77, 23),
                new SourceDestinationMap(81, 45, 19),
                new SourceDestinationMap(68, 64, 13)
        );

        List<SourceDestinationMap> expectedTemperatureToHumidityMap = List.of(
                new SourceDestinationMap(0, 69, 1),
                new SourceDestinationMap(1, 0, 69)
        );

        List<SourceDestinationMap> expectedHumidityToLocationMap = List.of(
                new SourceDestinationMap(60, 56, 37),
                new SourceDestinationMap(56, 93, 4)
        );

        Assertions.assertEquals(expectedSeeds, almanac.getSeeds());
        Assertions.assertEquals(expectedSeedToSoilMap, almanac.getListOfMaps().get(0));
        Assertions.assertEquals(expectedSoilToFertilizerMap, almanac.getListOfMaps().get(1));
        Assertions.assertEquals(expectedFertilizerToWaterMap, almanac.getListOfMaps().get(2));
        Assertions.assertEquals(expectedWaterToLightMap, almanac.getListOfMaps().get(3));
        Assertions.assertEquals(expectedLightToTemperatureMap, almanac.getListOfMaps().get(4));
        Assertions.assertEquals(expectedTemperatureToHumidityMap, almanac.getListOfMaps().get(5));
        Assertions.assertEquals(expectedHumidityToLocationMap, almanac.getListOfMaps().get(6));
    }
}

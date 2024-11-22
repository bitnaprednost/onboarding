package hr.bp.adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static hr.bp.adventofcode.day02.TestUtils.getShortGameInformation;
import static hr.bp.adventofcode.day02.TestUtils.getShortInput;

public class InputParserTest {

    private static final InputParser inputParser = new InputParser();;


    @Test
    public void testShortInput() {
        String input = getShortInput();

        Map<Integer, List<Map<Color, Integer>>> expectedGameInformation = getShortGameInformation();

        Map<Integer, List<Map<Color, Integer>>> actualGameInformation = inputParser.parse(input);

        assertMapsEqual(expectedGameInformation, actualGameInformation);

    }

    private void assertMapsEqual(Map<Integer, List<Map<Color, Integer>>> expected, Map<Integer, List<Map<Color, Integer>>> actual) {
        Assertions.assertEquals(expected, actual, "The parsed map does not match the expected map.");
    }




}

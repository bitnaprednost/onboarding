package hr.bp.adventofcode.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.adventofcode.day06.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day06.TestUtils.getFirstInputParsed;

/**
 * @author Ivan Tomičić
 */
public class RunRacesTest {

    @Test
    public void parseRaces_givenASimpleRaceInput_returnsCorrectParsedRaces() {
        String input = getFirstInput();
        RacesRunner runRaces = new RacesRunner(input);

        List<RaceRecord> expectedRaceRecords = getFirstInputParsed();

        List<RaceRecord> actualRaceRecords = runRaces.getRaceRecords();

        Assertions.assertEquals(expectedRaceRecords, actualRaceRecords);
    }
}

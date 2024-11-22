package hr.bp.adventofcode.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.adventofcode.day06.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day06.TestUtils.getFirstInputParsed;
import static hr.bp.adventofcode.day06.TestUtils.getSecondInput;
import static hr.bp.adventofcode.day06.TestUtils.getSecondInputParsed;

/**
 * @author Ivan Tomičić
 */
public class RacesRunnerTest {

    @Test
    public void parseRaces_givenTheFirstRaceInput_returnsCorrectParsedRaces() {
        String input = getFirstInput();
        RacesRunner racesRunner = new RacesRunner(input);

        List<Race> expectedRaceRecords = getFirstInputParsed();

        List<Race> actualRaceRecords = racesRunner.getRacess();

        Assertions.assertEquals(expectedRaceRecords, actualRaceRecords);
    }

    @Test
    public void parseRaces_givenTheSecondRaceInput_returnsCorrectParsedRaces() {
        String input = getSecondInput();
        RacesRunner racesRunner = new RacesRunner(input);

        List<Race> expectedRaceRecords = getSecondInputParsed();

        List<Race> actualRaceRecords = racesRunner.getRacess();

        Assertions.assertEquals(expectedRaceRecords, actualRaceRecords);
    }

    @Test
    public void multiplyResultsOfAllRaces_givenTheFirstRaceInput_returnsCorrectResult() {
        String input = getFirstInput();
        RacesRunner racesRunner = new RacesRunner(input);

        int expectedResult = 288;

        int actualResult = racesRunner.multiplyResultsOfAllRaces();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void multiplyResultsOfAllRaces_givenTheSecondRaceInput_returnsCorrectResult() {
        String input = getSecondInput();
        RacesRunner racesRunner = new RacesRunner(input);

        int expectedResult = 393120;

        int actualResult = racesRunner.multiplyResultsOfAllRaces();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}

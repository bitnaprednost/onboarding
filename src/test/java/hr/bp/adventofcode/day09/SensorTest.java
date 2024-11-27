package hr.bp.adventofcode.day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.adventofcode.day09.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day09.TestUtils.getHistoryFirstInput;

/**
 * @author Ivan Tomičić
 */
public class SensorTest {

    @Test
    public void parseInputIntoList_givenValidInputOne_correctlyParsesInput() {
        String input = getFirstInput();
        Sensor sensor = new Sensor(input);

        List<PolynomialEquation> expectedHistory = getHistoryFirstInput();

        List<PolynomialEquation> actualHistory = sensor.getHistory();

        Assertions.assertEquals(expectedHistory, actualHistory);
    }
}

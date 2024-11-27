package hr.bp.adventofcode.day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static hr.bp.adventofcode.Utils.readInputForDay;
import static hr.bp.adventofcode.day09.BigDecimalUtils.areBigDecimalsEqual;
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

    @Test
    public void nextValuesSummed_givenValidInputOne_returnsCorrectSum() {
        String input = getFirstInput();
        Sensor sensor = new Sensor(input);

        BigDecimal expectedSum = BigDecimal.valueOf(114);

        BigDecimal actualSum = sensor.sumNextValues();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalsEqual(expectedSum, actualSum, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void nextValuesSummed_givenValidInputTwo_returnsCorrectSum() {
        String input = readInputForDay("day09");
        Sensor sensor = new Sensor(input);

        BigDecimal expectedSum = BigDecimal.valueOf(1934898178);

        BigDecimal actualSum = sensor.sumNextValues();

        double tolerance = 1;
        Assertions.assertTrue(areBigDecimalsEqual(expectedSum, actualSum, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void previousValuesSummed_givenValidInputTwo_returnsCorrectSum() {
        String input = readInputForDay("day09");
        Sensor sensor = new Sensor(input);

        BigDecimal expectedSum = BigDecimal.valueOf(1129);

        BigDecimal actualSum = sensor.sumPreviousValues();

        double tolerance = 1;
        Assertions.assertTrue(areBigDecimalsEqual(expectedSum, actualSum, tolerance),
                "The coefficients do not match within the tolerance.");
    }
}

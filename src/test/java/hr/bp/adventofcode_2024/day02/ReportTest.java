package hr.bp.adventofcode_2024.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class ReportTest {

    @Test
    public void isReportSafe_givenReportOne_returnsIsSafe() {
        Report report = new Report(List.of(7, 6, 4, 2, 1));

        boolean expectedIsSafe = true;

        boolean actualIsSafe = report.isSafe();

        Assertions.assertEquals(expectedIsSafe, actualIsSafe);
    }

    @Test
    public void isReportSafe_givenReportTwo_returnsIsNotSafe() {
        Report report = new Report(List.of(1,2,7,8,9));

        boolean expectedIsSafe = true;

        boolean actualIsSafe = report.isSafe();

        Assertions.assertEquals(expectedIsSafe, actualIsSafe);
    }

    @Test
    public void isReportSafe_givenReportThree_returnsIsNotSafe() {
        Report report = new Report(List.of(9,7,6,2,1));

        boolean expectedIsSafe = true;

        boolean actualIsSafe = report.isSafe();

        Assertions.assertEquals(expectedIsSafe, actualIsSafe);
    }

    @Test
    public void isReportSafe_givenReportFour_returnsIsNotSafe() {
        Report report = new Report(List.of(1,3,2,4,5));

        boolean expectedIsSafe = true;

        boolean actualIsSafe = report.isSafe();

        Assertions.assertEquals(expectedIsSafe, actualIsSafe);
    }

    @Test
    public void isReportSafe_givenReportFive_returnsIsNotSafe() {
        Report report = new Report(List.of(8,6,4,4,1));

        boolean expectedIsSafe = true;

        boolean actualIsSafe = report.isSafe();

        Assertions.assertEquals(expectedIsSafe, actualIsSafe);
    }

    @Test
    public void isReportSafe_givenReportSix_returnsIsSafe() {
        Report report = new Report(List.of(1,3,6,7,9));

        boolean expectedIsSafe = true;

        boolean actualIsSafe = report.isSafe();

        Assertions.assertEquals(expectedIsSafe, actualIsSafe);
    }
}

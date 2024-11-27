package hr.bp.adventofcode.day09;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class TestUtils {

    public static String getFirstInput() {
        return """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45""";
    }

    public static List<PolynomialEquation> getHistoryFirstInput() {
        return List.of(
                new PolynomialEquation(List.of(0, 3, 6, 9, 12, 15)),
                new PolynomialEquation(List.of(1, 3, 6, 10, 15, 21)),
                new PolynomialEquation(List.of(10, 13, 16, 21, 30, 45))
        );
    }
}

package hr.bp.adventofcode.day09;

import java.math.BigDecimal;
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

    public static boolean areBigDecimalArraysEqual(BigDecimal[] v1, BigDecimal[] v2, double tolerance) {
        if (v1.length != v2.length) {
            return false;
        }

        for (int i = 0; i < v1.length; i++) {
            if (!areBigDecimalsEqual(v1[i], v2[i], tolerance)) {
                return false;
            }
        }

        return true;
    }

    public static boolean areBigDecimalsEqual(BigDecimal number1, BigDecimal number2, double tolerance) {
        if (Math.abs(number1.subtract(number2).doubleValue()) > tolerance) {
            return false;
        }

        return true;
    }

}

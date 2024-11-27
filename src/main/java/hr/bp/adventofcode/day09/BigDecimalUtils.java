package hr.bp.adventofcode.day09;

import java.math.BigDecimal;

/**
 * @author Ivan Tomičić
 */
public class BigDecimalUtils {

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
        return !(Math.abs(number1.subtract(number2).doubleValue()) > tolerance);
    }
}

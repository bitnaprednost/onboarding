package hr.bp.adventofcode.day09;
import org.apache.commons.math3.linear.RealVector;

/**
 * @author Ivan Tomičić
 */

public class VectorUtils {
    public static boolean areVectorsEqual(RealVector v1, RealVector v2, double tolerance) {
        if (v1.getDimension() != v2.getDimension()) {
            return false;
        }
        for (int i = 0; i < v1.getDimension(); i++) {
            if (Math.abs(v1.getEntry(i) - v2.getEntry(i)) > tolerance) {
                return false;
            }
        }
        return true;
    }
}

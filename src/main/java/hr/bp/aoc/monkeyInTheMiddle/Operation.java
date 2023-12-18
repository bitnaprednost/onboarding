package hr.bp.aoc.monkeyInTheMiddle;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * <p>Operation class.</p>
 *
 * @author Marko Krišković
 */
public enum Operation {
    PLUS("+"){
        @Override
        public CombinedFunctionalInterface initializeFunction(Integer x1, Integer x2, int mode) {
            return new CombinedFunctionalInterface(mode) {
                @Override
                public BigInteger apply(BigInteger old) {
                    return old.add(old);
                }

                @Override
                public BigInteger apply2(BigInteger old) {
                    return old.add(BigInteger.valueOf(x1));
                }

                @Override
                public BigInteger get() {
                    return BigInteger.valueOf((long) x1 + x2);
                }
            };
        }
    },
    TIMES("*"){
        @Override
        public CombinedFunctionalInterface initializeFunction(Integer x1, Integer x2, int mode) {
            return new CombinedFunctionalInterface(mode) {
                @Override
                public BigInteger apply(BigInteger old) {
                    return old.multiply(old);
                }

                @Override
                public BigInteger apply2(BigInteger old) {
                    return old.multiply(BigInteger.valueOf(x1));
                }

                @Override
                public BigInteger get() {
                    return BigInteger.valueOf((long) x1 * x2);
                }
            };
        }
    };

    private final String text;
    Operation(String text) {
        this.text=text;
    }

    public abstract CombinedFunctionalInterface initializeFunction(Integer x1, Integer x2, int mode);

    public static Operation from(String str) {
        return Arrays.stream(values())
                .filter(o -> o.text.equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return text;
    }
}

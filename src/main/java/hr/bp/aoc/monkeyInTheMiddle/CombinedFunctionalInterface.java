package hr.bp.aoc.monkeyInTheMiddle;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.LongUnaryOperator;
import java.util.function.Supplier;

/**
 * <p>Abstract CombinedFunctionalInterface class.</p>
 *
 * @author Marko Krišković
 */
public abstract class CombinedFunctionalInterface implements Function<BigInteger, BigInteger>, Supplier<BigInteger> {
    private int functionMode;

    protected CombinedFunctionalInterface(int functionMode) {
        this.functionMode = functionMode;
    }

    public void setFunctionMode(int functionMode) {
        this.functionMode = functionMode;
    }

    public BigInteger operation(BigInteger old){
        return switch (functionMode){
            // number +* number
            case 0 -> get();
            // old +* number
            case 1 ->  apply2(old);
            // old +* old
            case 2 -> apply(old);
            default -> throw new UnsupportedOperationException();
        };
    }

    abstract BigInteger apply2(BigInteger old);
}

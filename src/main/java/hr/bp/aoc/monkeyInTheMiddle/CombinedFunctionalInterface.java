package hr.bp.aoc.monkeyInTheMiddle;

import java.util.function.LongSupplier;
import java.util.function.LongUnaryOperator;

public abstract class CombinedFunctionalInterface implements LongUnaryOperator, LongSupplier {
    private int functionMode;

    protected CombinedFunctionalInterface(int functionMode) {
        this.functionMode = functionMode;
    }

    public void setFunctionMode(int functionMode) {
        this.functionMode = functionMode;
    }

    public long operation(Long old){
        return switch (functionMode){
            // number +* number
            case 0 -> getAsLong();
            // old +* number
            case 1 ->  apply2(old);
            // old +* old
            case 2 -> applyAsLong(old);
            default -> throw new UnsupportedOperationException();
        };
    }

    abstract long apply2(long old);
}

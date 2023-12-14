package hr.bp.aoc.monkeyInTheMiddle;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class CombinedFunctionalInterface implements Function<Integer, Integer>, Supplier<Integer> {
    private int functionMode;

    public CombinedFunctionalInterface(int functionMode) {
        this.functionMode = functionMode;
    }

    public void setFunctionMode(int functionMode) {
        this.functionMode = functionMode;
    }

    public Integer operation(Integer old){
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

    abstract Integer apply2(Integer integer);
}

package hr.bp.aoc.monkeyInTheMiddle;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public abstract class CombinedFunctionalInterface implements BiFunction<Integer, Integer, Integer>, Supplier<Integer> {
    private int functionMode;

    public void setFunctionMode(int functionMode) {
        this.functionMode = functionMode;
    }

    public int getFunctionMode() {
        return functionMode;
    }

    abstract Integer apply2(Integer integer);
}

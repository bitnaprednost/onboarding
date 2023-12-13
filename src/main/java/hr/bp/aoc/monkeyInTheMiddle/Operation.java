package hr.bp.aoc.monkeyInTheMiddle;

import java.util.Arrays;

public enum Operation {
    PLUS("+"){
        @Override
        public CombinedFunctionalInterface initializeFunction(Integer x1, Integer x2) {
            return new CombinedFunctionalInterface() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return integer + integer2;
                }

                @Override
                public Integer apply2(Integer integer) {
                    return x1 + integer;
                }

                @Override
                public Integer get() {
                    return x1 + x2;
                }
            };
        }
    },
    TIMES("*"){
        @Override
        public CombinedFunctionalInterface initializeFunction(Integer x1, Integer x2) {
            return new CombinedFunctionalInterface() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return integer * integer;
                }

                @Override
                public Integer apply2(Integer integer) {
                    return integer * x1;
                }

                @Override
                public Integer get() {
                    return x1 * x2;
                }
            };
        }
    };

    private final String text;
    Operation(String text) {
        this.text=text;
    }

    public abstract CombinedFunctionalInterface initializeFunction(Integer x1, Integer x2);

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

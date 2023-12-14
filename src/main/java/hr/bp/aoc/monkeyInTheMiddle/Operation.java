package hr.bp.aoc.monkeyInTheMiddle;

import java.util.Arrays;

public enum Operation {
    PLUS("+"){
        @Override
        public CombinedFunctionalInterface initializeFunction(Long x1, Long x2, int mode) {
            return new CombinedFunctionalInterface(mode) {
                @Override
                public long applyAsLong(long old) {
                    return old + old;
                }

                @Override
                public long apply2(long old) {
                    return x1 + old;
                }

                @Override
                public long getAsLong() {
                    return x1 + x2;
                }
            };
        }
    },
    TIMES("*"){
        @Override
        public CombinedFunctionalInterface initializeFunction(Long x1, Long x2, int mode) {
            return new CombinedFunctionalInterface(mode) {
                @Override
                public long applyAsLong(long old) {
                    return old * old;
                }

                @Override
                public long apply2(long old) {
                    return old * x1;
                }

                @Override
                public long getAsLong() {
                    return x1 * x2;
                }
            };
        }
    };

    private final String text;
    Operation(String text) {
        this.text=text;
    }

    public abstract CombinedFunctionalInterface initializeFunction(Long x1, Long x2, int mode);

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

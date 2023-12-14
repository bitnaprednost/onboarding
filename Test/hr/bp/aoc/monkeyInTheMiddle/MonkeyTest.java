package hr.bp.aoc.monkeyInTheMiddle;

import hr.bp.aoc.monkeyInTheMiddle.monkey.Monkey;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyTest {
    private Monkey monkey0;
    private Monkey monkey1;
    private Monkey monkey2;
    private Monkey monkey3;
    @BeforeEach
    void setUp() {
        MonkeyBuilder builder0 = new MonkeyBuilder();

        monkey0 = builder0.setId(0)
                .setItems(List.of(79L, 98L))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(3)
                .setDivisibleBy(23)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    long apply2(long old) {
                        return old * 19;
                    }

                    @Override
                    public long applyAsLong(long old) {
                        return -1;
                    }

                    @Override
                    public long getAsLong() {
                        return -1;
                    }
                })
                .build();

        MonkeyBuilder builder1 = new MonkeyBuilder();

        monkey1 = builder1.setId(1)
                .setItems(List.of(54L, 65L, 75L, 74L))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(0)
                .setDivisibleBy(19)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    long apply2(long old) {
                        return old + 6;
                    }

                    @Override
                    public long applyAsLong(long old) {
                        return -1;
                    }

                    @Override
                    public long getAsLong() {
                        return -1;
                    }
                })
                .build();

        MonkeyBuilder builder2 = new MonkeyBuilder();

        monkey2 = builder2.setId(2)
                .setItems(List.of(79L, 60L, 97L))
                .setMonkeyTrueId(1)
                .setMonkeyFalseId(3)
                .setDivisibleBy(13)
                .setFunction(new CombinedFunctionalInterface(2) {
                    @Override
                    long apply2(long old) {
                        return -1;
                    }

                    @Override
                    public long applyAsLong(long old) {
                        return old * old;
                    }

                    @Override
                    public long getAsLong() {
                        return -1;
                    }
                })
                .build();

        MonkeyBuilder builder3 = new MonkeyBuilder();

        monkey3 = builder3.setId(3)
                .setItems(List.of(74L))
                .setMonkeyTrueId(0)
                .setMonkeyFalseId(1)
                .setDivisibleBy(17)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    long apply2(long old) {
                        return old + 3;
                    }

                    @Override
                    public long applyAsLong(long old) {
                        return -1;
                    }

                    @Override
                    public long getAsLong() {
                        return -1;
                    }
                })
                .build();

        MonkeyBuilder[] builders = {builder0, builder1, builder2, builder3};
        Monkey[] monkeys = {monkey0, monkey1, monkey2, monkey3};

        for(MonkeyBuilder monkeyBuilder : builders){
            monkeyBuilder.setThrowMonkeys(monkeys);
        }
    }

    @Test
    void canInspectAllItems(){
        monkey0.inspectItems();

        assertEquals("Monkey 0: []", monkey0.toString());
        assertEquals("Monkey 1: [54, 65, 75, 74]", monkey1.toString());
        assertEquals("Monkey 2: [79, 60, 97]", monkey2.toString());
        assertEquals("Monkey 3: [74, 500, 620]", monkey3.toString());
    }

    @Test
    void canGetNumberOfInspectedTimes(){
        monkey0.inspectItems();
        monkey1.inspectItems();
        monkey2.inspectItems();
        monkey3.inspectItems();

        assertEquals(2, monkey0.getTimesInspectedItems());
        assertEquals(4, monkey1.getTimesInspectedItems());
        assertEquals(3, monkey2.getTimesInspectedItems());
        assertEquals(5, monkey3.getTimesInspectedItems());
    }
}
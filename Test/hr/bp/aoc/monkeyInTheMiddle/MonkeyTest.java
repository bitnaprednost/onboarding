package hr.bp.aoc.monkeyInTheMiddle;

import hr.bp.aoc.monkeyInTheMiddle.monkey.Monkey;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
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
                .setItems(List.of(BigInteger.valueOf(79), BigInteger.valueOf(98)))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(3)
                .setDivisibleBy(23)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    public BigInteger get() {
                        return null;
                    }

                    @Override
                    public BigInteger apply(BigInteger old) {
                        return null;
                    }

                    @Override
                    BigInteger apply2(BigInteger old) {
                        return old.multiply(BigInteger.valueOf(19));
                    }
                })
                .build();

        MonkeyBuilder builder1 = new MonkeyBuilder();

        monkey1 = builder1.setId(1)
                .setItems(List.of(BigInteger.valueOf(54), BigInteger.valueOf(65), BigInteger.valueOf(75), BigInteger.valueOf(74)))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(0)
                .setDivisibleBy(19)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    public BigInteger get() {
                        return null;
                    }

                    @Override
                    public BigInteger apply(BigInteger old) {
                        return null;
                    }

                    @Override
                    BigInteger apply2(BigInteger old) {
                        return old.add(BigInteger.valueOf(6));
                    }
                })
                .build();

        MonkeyBuilder builder2 = new MonkeyBuilder();

        monkey2 = builder2.setId(2)
                .setItems(List.of(BigInteger.valueOf(79), BigInteger.valueOf(60), BigInteger.valueOf(97)))
                .setMonkeyTrueId(1)
                .setMonkeyFalseId(3)
                .setDivisibleBy(13)
                .setFunction(new CombinedFunctionalInterface(2) {
                    @Override
                    public BigInteger get() {
                        return null;
                    }

                    @Override
                    public BigInteger apply(BigInteger old) {
                        return old.multiply(old);
                    }

                    @Override
                    BigInteger apply2(BigInteger old) {
                        return null;
                    }
                })
                .build();

        MonkeyBuilder builder3 = new MonkeyBuilder();

        monkey3 = builder3.setId(3)
                .setItems(List.of(BigInteger.valueOf(74)))
                .setMonkeyTrueId(0)
                .setMonkeyFalseId(1)
                .setDivisibleBy(17)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    public BigInteger get() {
                        return null;
                    }

                    @Override
                    public BigInteger apply(BigInteger bigInteger) {
                        return null;
                    }

                    @Override
                    BigInteger apply2(BigInteger old) {
                        return old.add(BigInteger.valueOf(3));
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
        monkey0.inspectItems(96577);

        assertEquals("Monkey 0: []", monkey0.toString());
        assertEquals("Monkey 1: [54, 65, 75, 74]", monkey1.toString());
        assertEquals("Monkey 2: [79, 60, 97]", monkey2.toString());
        assertEquals("Monkey 3: [74, 500, 620]", monkey3.toString());
    }

    @Test
    void canGetNumberOfInspectedTimes(){
        monkey0.inspectItems(96577);
        monkey1.inspectItems(96577);
        monkey2.inspectItems(96577);
        monkey3.inspectItems(96577);

        assertEquals(2, monkey0.getTimesInspectedItems());
        assertEquals(4, monkey1.getTimesInspectedItems());
        assertEquals(3, monkey2.getTimesInspectedItems());
        assertEquals(5, monkey3.getTimesInspectedItems());
    }
}
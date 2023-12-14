package hr.bp.aoc.monkeyInTheMiddle;

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
                .setItems(List.of(79, 98))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(3)
                .setDivisibleBy(23)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    Integer apply2(Integer integer) {
                        return integer * 19;
                    }

                    @Override
                    public Integer apply(Integer integer) {
                        return null;
                    }

                    @Override
                    public Integer get() {
                        return null;
                    }
                })
                .build();

        MonkeyBuilder builder1 = new MonkeyBuilder();

        monkey1 = builder1.setId(1)
                .setItems(List.of(54, 65, 75, 74))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(0)
                .setDivisibleBy(19)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    Integer apply2(Integer integer) {
                        return integer + 6;
                    }

                    @Override
                    public Integer apply(Integer integer) {
                        return null;
                    }

                    @Override
                    public Integer get() {
                        return null;
                    }
                })
                .build();

        MonkeyBuilder builder2 = new MonkeyBuilder();

        monkey2 = builder2.setId(2)
                .setItems(List.of(79, 60, 97))
                .setMonkeyTrueId(1)
                .setMonkeyFalseId(3)
                .setDivisibleBy(13)
                .setFunction(new CombinedFunctionalInterface(2) {
                    @Override
                    Integer apply2(Integer integer) {
                        return null;
                    }

                    @Override
                    public Integer apply(Integer integer) {
                        return integer * integer;
                    }

                    @Override
                    public Integer get() {
                        return null;
                    }
                })
                .build();

        MonkeyBuilder builder3 = new MonkeyBuilder();

        monkey3 = builder3.setId(3)
                .setItems(List.of(74))
                .setMonkeyTrueId(0)
                .setMonkeyFalseId(1)
                .setDivisibleBy(17)
                .setFunction(new CombinedFunctionalInterface(1) {
                    @Override
                    Integer apply2(Integer integer) {
                        return integer + 3;
                    }

                    @Override
                    public Integer apply(Integer integer) {
                        return null;
                    }

                    @Override
                    public Integer get() {
                        return null;
                    }
                })
                .build();

        MonkeyBuilder[] builders = {builder0, builder1, builder2, builder3};
        Monkey[] monkeys = {monkey0, monkey1, monkey2, monkey3};
        for (int i=0;i<4;i++){
            monkeys[i].setTrueMonkey(monkeys[builders[i].getMonkeyTrueId()]);
            monkeys[i].setFalseMonkey(monkeys[builders[i].getMonkeyFalseId()]);
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
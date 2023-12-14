package hr.bp.aoc.monkeyInTheMiddle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyManagerTest {
    private MonkeyManager monkeyManager;

    @BeforeEach
    void setUp() {
        MonkeyBuilder builder0 = new MonkeyBuilder();

        Monkey monkey0 = builder0.setId(0)
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

        Monkey monkey1 = builder1.setId(1)
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

        Monkey monkey2 = builder2.setId(2)
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

        Monkey monkey3 = builder3.setId(3)
                .setItems(List.of(74))
                .setMonkeyTrueId(0)
                .setMonkeyFalseId(1)
                .setDivisibleBy(17)
                .setFunction( new CombinedFunctionalInterface(1) {
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

        monkeyManager = MonkeyManager.of(monkeys);
    }

    @Test
    void canSimulateRound(){
        monkeyManager.simulateRounds(1);

        String result = """
                Monkey 0: [20, 23, 27, 26]
                Monkey 1: [2080, 25, 167, 207, 401, 1046]
                Monkey 2: []
                Monkey 3: []
                """;

        assertEquals(result, monkeyManager.toString());
    }

    @Test
    void canSimulateMultipleRounds(){
        monkeyManager.simulateRounds(20);

        String result = """
                Monkey 0: [10, 12, 14, 26, 34]
                Monkey 1: [245, 93, 53, 199, 115]
                Monkey 2: []
                Monkey 3: []
                """;

        assertEquals(result, monkeyManager.toString());
    }

    @Test
    void cantSimulateNegativeRounds(){
        monkeyManager.simulateRounds(-5);

        String result = """
                Monkey 0: [79, 98]
                Monkey 1: [54, 65, 75, 74]
                Monkey 2: [79, 60, 97]
                Monkey 3: [74]
                """;

        assertEquals(result, monkeyManager.toString());
    }

    @Test
    void cantSimulateZeroRounds(){
        monkeyManager.simulateRounds(0);

        String result = """
                Monkey 0: [79, 98]
                Monkey 1: [54, 65, 75, 74]
                Monkey 2: [79, 60, 97]
                Monkey 3: [74]
                """;

        assertEquals(result, monkeyManager.toString());
    }

    @Test
    void canGetNumberOfInspectedTimes(){
        monkeyManager.simulateRounds(1);

        assertEquals(2, monkeyManager.getTimesInspectedItems(0));
        assertEquals(4, monkeyManager.getTimesInspectedItems(1));
        assertEquals(3, monkeyManager.getTimesInspectedItems(2));
        assertEquals(5, monkeyManager.getTimesInspectedItems(3));
    }

    @Test
    void cantGetNumberOfInspectedTimesIncorrectId(){
        monkeyManager.simulateRounds(1);

        assertThrows(NoSuchElementException.class, () -> {int lol = monkeyManager.getTimesInspectedItems(-1);});
    }

    @Test
    void canGetNumberOfInspectedMultipleTimes(){
        monkeyManager.simulateRounds(20);

        assertEquals(101, monkeyManager.getTimesInspectedItems(0));
        assertEquals(95, monkeyManager.getTimesInspectedItems(1));
        assertEquals(7, monkeyManager.getTimesInspectedItems(2));
        assertEquals(105, monkeyManager.getTimesInspectedItems(3));
    }

    @Test
    void canReturnTopTwoMostActiveMonkeys(){
        monkeyManager.simulateRounds(20);
        List<Monkey> mostActiveMonkeys = monkeyManager.getTopActiveMonkeys(2);

        assertEquals(3, mostActiveMonkeys.get(0).getId());
        assertEquals(0, mostActiveMonkeys.get(1).getId());
    }

    @Test
    void canReturnProductOfTopTwoMonkeys(){
        monkeyManager.simulateRounds(20);
        Integer product = monkeyManager.getProductOfTopActiveMonkeys(2);

        assertEquals(10605, product);
    }
}
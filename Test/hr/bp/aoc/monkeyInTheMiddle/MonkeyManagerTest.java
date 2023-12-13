package hr.bp.aoc.monkeyInTheMiddle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyManagerTest {
    private Monkey monkey0;
    private Monkey monkey1;
    private Monkey monkey2;
    private Monkey monkey3;
    private MonkeyManager monkeyManager;

    @BeforeEach
    void setUp() {
        monkey0 = new Monkey(0, List.of(79, 98)) {
            @Override
            Integer operation(Integer old) {
                return old * 19;
            }

            @Override
            void test() {
                if(items.getFirst()%23==0) throwToMonkey(monkey2);
                else throwToMonkey(monkey3);
            }
        };

        monkey1 = new Monkey(1, List.of(54, 65, 75, 74)) {
            @Override
            Integer operation(Integer old) {
                return old + 6;
            }

            @Override
            void test() {
                if(items.getFirst()%19==0) throwToMonkey(monkey2);
                else throwToMonkey(monkey0);
            }
        };

        monkey2 = new Monkey(2, List.of(79, 60, 97)) {
            @Override
            Integer operation(Integer old) {
                return old * old;
            }

            @Override
            void test() {
                if(items.getFirst()%13==0) throwToMonkey(monkey1);
                else throwToMonkey(monkey3);
            }
        };

        monkey3 = new Monkey(3, List.of(74)) {
            @Override
            Integer operation(Integer old) {
                return old + 3;
            }

            @Override
            void test() {
                if(items.getFirst()%17==0) throwToMonkey(monkey0);
                else throwToMonkey(monkey1);
            }
        };

        monkeyManager = MonkeyManager.of(monkey0, monkey1, monkey2, monkey3);
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
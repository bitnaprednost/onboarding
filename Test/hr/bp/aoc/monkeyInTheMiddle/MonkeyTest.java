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
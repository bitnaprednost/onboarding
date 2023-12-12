package hr.bp.aoc.monkeyInTheMiddle;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

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
            void test(int position) {
                if(items.get(position)%23==0) throwToMonkey(position, monkey2);
                else throwToMonkey(position, monkey3);
            }
        };

        monkey1 = new Monkey(1, List.of(54, 65, 75, 74)) {
            @Override
            Integer operation(Integer old) {
                return old + 6;
            }

            @Override
            void test(int position) {
                if(items.get(position)%19==0) throwToMonkey(position, monkey2);
                else throwToMonkey(position, monkey0);
            }
        };

        monkey2 = new Monkey(2, List.of(79, 60, 97)) {
            @Override
            Integer operation(Integer old) {
                return old * old;
            }

            @Override
            void test(int position) {
                if(items.get(position)%13==0) throwToMonkey(position, monkey1);
                else throwToMonkey(position, monkey3);
            }
        };

        monkey3 = new Monkey(3, List.of(74)) {
            @Override
            Integer operation(Integer old) {
                return old + 3;
            }

            @Override
            void test(int position) {
                if(items.get(position)%17==0) throwToMonkey(position, monkey0);
                else throwToMonkey(position, monkey1);
            }
        };

        monkeyManager = MonkeyManager.of(monkey0, monkey1, monkey2, monkey3);
    }
}
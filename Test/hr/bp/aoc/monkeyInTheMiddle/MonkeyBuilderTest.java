package hr.bp.aoc.monkeyInTheMiddle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyBuilderTest {
    MonkeyBuilder builder;
    @BeforeEach
    void setUp() {
        builder = new MonkeyBuilder();
    }

    @Test
    void canSetMonkeyId(){
        int id = 0;
        builder.setId(id);

        assertEquals(id, builder.getId());
    }

    @Test
    void cantSetNegativeMonkeyId(){
        int id = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->builder.setId(id));
        assertEquals("Id must be positive", exception.getMessage());
    }

    @Test
    void canSetDivisibleBy(){
        int divisibleBy = 1;
        builder.setDivisibleBy(divisibleBy);

        assertEquals(divisibleBy, builder.getDivisibleBy());
    }

    @Test
    void cantSetNonPositiveDivisibleBy(){
        int divisibleBy = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->builder.setDivisibleBy(divisibleBy));
        assertEquals("Divisible number must be positive", exception.getMessage());

        int divisibleBy2 = 0;

        exception = assertThrows(IllegalArgumentException.class, ()->builder.setDivisibleBy(divisibleBy2));
        assertEquals("Divisible number must be positive", exception.getMessage());
    }

    @Test
    void canSetItems(){
        List<Integer> items = List.of(79, 98);
        builder.setItems(items);

        assertEquals(items, builder.getItems());
    }

    @Test
    void canBuildMonkey(){
        
        builder.setId(0)
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
                .setItems(List.of(79, 98))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(3);

        Monkey monkey = builder.build();

        assertEquals("Monkey 0: [79, 98]", monkey.toString());
    }
}
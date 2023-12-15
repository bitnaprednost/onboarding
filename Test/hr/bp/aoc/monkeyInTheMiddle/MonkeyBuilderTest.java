package hr.bp.aoc.monkeyInTheMiddle;

import hr.bp.aoc.monkeyInTheMiddle.monkey.Monkey;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
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
        List<BigInteger> items = List.of(BigInteger.valueOf(79), BigInteger.valueOf(98));
        builder.setItems(items);

        assertEquals(items, builder.getItems());
    }

    @Test
    void canBuildMonkey(){
        
        builder.setId(0)
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
                .setItems(List.of(BigInteger.valueOf(79), BigInteger.valueOf(98)))
                .setMonkeyTrueId(2)
                .setMonkeyFalseId(3);

        Monkey monkey = builder.build();

        assertEquals("Monkey 0: [79, 98]", monkey.toString());
    }
}
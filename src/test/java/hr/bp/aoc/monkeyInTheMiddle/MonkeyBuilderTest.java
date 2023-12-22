package hr.bp.aoc.monkeyInTheMiddle;

import hr.bp.aoc.monkeyInTheMiddle.monkey.Monkey;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyBuilderTest {
    Monkey monkey;
    MonkeyBuilder builder;
    @BeforeEach
    void setUp() {
        builder = new MonkeyBuilder().id(0)
            .divisibleBy(23)
            .function(new CombinedFunctionalInterface(1) {
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
            .items(List.of(BigInteger.valueOf(79), BigInteger.valueOf(98)))
            .trueId(2)
            .falseId(3);

        monkey = builder.build();
    }

    @Test
    void canSetMonkeyId(){
        int id = 0;

        assertEquals(id, monkey.getId());
    }

    @Test
    void cantSetNegativeMonkeyId(){
        int id = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->builder.id(id));
        assertEquals("Id must be positive", exception.getMessage());
    }

    @Test
    void canSetDivisibleBy(){
        int divisibleBy = 1;
        builder.divisibleBy(divisibleBy);
        Monkey monkey = builder.build();

        assertEquals(divisibleBy, monkey.getDivisibleBy());
    }

    @Test
    void cantSetNonPositiveDivisibleBy(){
        int divisibleBy = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->builder.divisibleBy(divisibleBy));
        assertEquals("Divisible number must be positive", exception.getMessage());

        int divisibleBy2 = 0;

        exception = assertThrows(IllegalArgumentException.class, ()->builder.divisibleBy(divisibleBy2));
        assertEquals("Divisible number must be positive", exception.getMessage());
    }

    @Test
    void canSetItems(){
        List<BigInteger> items = List.of(BigInteger.valueOf(79), BigInteger.valueOf(98));
        builder.items(items);

        assertEquals(items, builder.getItems());
    }

    @Test
    void canBuildMonkey(){
        


        assertEquals("Monkey 0: [79, 98]", monkey.toString());
    }
}
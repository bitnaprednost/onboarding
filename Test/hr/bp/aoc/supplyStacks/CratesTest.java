package hr.bp.aoc.supplyStacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CratesTest {
    Crates crates;

    @BeforeEach
    void init(){
        String boxesString = "    [D]    \n" +
                "[N] [C]    \n" +
                "[Z] [M] [P]\n" +
                " 1   2   3 ";
        Map<Integer, Stack<String>> stacks = ParserDay5.parseBoxes(boxesString);
        crates = new Crates(stacks);
    }
    @Test
    public void canPopFromStack(){
        int from = 2;
        String crate = crates.pop(from);

        assertEquals("D", crate);
    }

    @Test
    public void canPopFromEmptyStack(){
        int from = 3;
        String crate = crates.pop(from);

        assertThrows(EmptyStackException.class, () -> crates.pop(from));
    }

    @Test
    public void canPushIntoStack(){
        int to = 1;
        String crate = crates.push(to, "D");

        assertEquals("D", crate);
    }

    @Test
    public void canPeekIntoStack(){
        int into = 1;
        String crate = crates.peek(into);

        assertEquals("N", crate);
    }

    @Test
    public void canPopFromOnePushToOther(){
        int from = 2;
        int to = 1;
        crates.move(from, to);

        assertEquals("D", crates.peek(1));
    }

    @Test
    public void canGetTopOfEachStack(){
        String tops = crates.getTops();

        assertEquals("NDP", tops);
    }
}
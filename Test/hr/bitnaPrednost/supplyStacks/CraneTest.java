package hr.bitnaPrednost.supplyStacks;

import hr.bitnaPrednost.supplyStacks.crane.Crane;
import hr.bitnaPrednost.supplyStacks.crane.CrateMover9000;
import hr.bitnaPrednost.supplyStacks.crane.CrateMover9001;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CraneTest {
    Crane crane9000;
    Crane crane9001;
    Crates crates;
    @BeforeEach
    void init(){
        String boxesString = "    [D]    \n" +
                "[N] [C]    \n" +
                "[Z] [M] [P]\n" +
                " 1   2   3 ";
        Map<Integer, Stack<String>> stacks = ParserDay5.parseBoxes(boxesString);
        crates = new Crates(stacks);
        crane9000 = new CrateMover9000(crates);
        crane9001 = new CrateMover9001(crates);
    }

    @Test
    public void craneCanMoveCrate(){
        int amount = 1;
        int from = 2;
        int to = 1;
        crane9000.move(amount, from, to);

        assertEquals("D", crates.peek(1));
    }

    @Test
    public void craneCanMoveCrates(){
        int amount = 2;
        int from = 2;
        int to = 1;
        crane9000.move(amount, from, to);

        assertEquals("C", crates.peek(1));
    }

    @Test
    public void craneCanParseCommand(){
        String commandsString = "move 1 from 2 to 1";
        crane9000.parseCommand(commandsString);

        assertEquals("D", crates.peek(1));
    }

    @Test
    public void craneCanMoveCrate9001(){
        int amount = 1;
        int from = 2;
        int to = 1;
        crane9001.move(amount, from, to);

        assertEquals("D", crates.peek(1));
    }

    @Test
    public void craneCanMoveCrates9001(){
        int amount = 2;
        int from = 2;
        int to = 1;
        crane9001.move(amount, from, to);

        assertEquals("D", crates.peek(1));
    }
}
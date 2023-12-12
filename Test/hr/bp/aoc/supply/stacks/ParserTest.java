package hr.bp.aoc.supply.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import hr.bp.aoc.util.Parser;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    String boxesString;
    String commandsString;

    @BeforeEach
    void init(){
        boxesString = "    [D]\n" +
                        "[N] [C]\n" +
                        "[Z] [M] [P]\n" +
                        " 1   2   3 ";
        commandsString = "move 1 from 2 to 1\n" +
                        "move 3 from 1 to 3";
    }

    @Test
    public void parserCanGetInitialInput() throws IOException {
        String path = "Resources/testData.txt";
        String initialInput = Parser.getTextFromFile(path);

        assertEquals(initialInput, "Hello World\n" + "this is a test");
    }

    @Test
    public void parserCanGetInitialInputSplit() throws IOException {
        String path = "Resources/testData.txt";
        String[] initialInput = Parser.getLinesFromFile(path);

        assertEquals(initialInput[0], "Hello World");
        assertEquals(initialInput[1], "this is a test");
    }

    @Test
    public void parserCanSplitInputIntoTwoSections() throws IOException {
        String input = "    [D]\n" +
                "[N] [C]\n" +
                "[Z] [M] [P]\n" +
                " 1   2   3 \n" +
                "\n" +
                "move 1 from 2 to 1\n" +
                "move 3 from 1 to 3";
        String[] split = ParserDay5.splitInput(input);

        assertEquals(boxesString, split[0]);
        assertEquals(commandsString, split[1]);
    }

    @Test
    public void parserMakesLotsOfStacks() throws IOException {
        int numberOfWantedBoxes = 3;
        List<Stack<String>> stacks = ParserDay5.createStacks(numberOfWantedBoxes);

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Stack<String> stack3 = new Stack<>();
        List<Stack<String>> list = new ArrayList<>();
        list.add(stack1);
        list.add(stack2);
        list.add(stack3);

        assertEquals(list, stacks);
    }

    @Test
    public void parserCanParseBoxes() throws IOException {
        Map<Integer, Stack<String>> boxes = ParserDay5.parseBoxes(boxesString);

        Stack<String> stack1 = new Stack<>();
        stack1.push("Z");
        stack1.push("N");
        Stack<String> stack2 = new Stack<>();
        stack2.push("M");
        stack2.push("C");
        stack2.push("D");
        Stack<String> stack3 = new Stack<>();
        stack3.push("P");
        Map<Integer, Stack<String>> map = new HashMap<>();
        map.put(1, stack1);
        map.put(2, stack2);
        map.put(3, stack3);

        assertEquals(map, boxes);
    }

    @Test
    public void parserCanParseCommands(){
        String[] commands = ParserDay5.parseCommands(commandsString);

        assertAll("Commands match",
                () -> assertEquals("move 1 from 2 to 1", commands[0]),
                () -> assertEquals("move 3 from 1 to 3", commands[1])
        );
    }
}
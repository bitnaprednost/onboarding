package hr.bp.aoc2024.day3;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("aoc2024/inputDay3.txt");
        MemoryParser parser = new MemoryParser(document);
        Memory memory = new Memory(parser.getCommands());

        System.out.println(memory.getMultiplicationSum());
    }
}

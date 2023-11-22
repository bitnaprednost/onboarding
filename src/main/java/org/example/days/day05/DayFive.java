package org.example.days.day05;

import org.example.Utility.ParseUtility;
import org.example.days.day05.model.Instruction;
import org.example.days.model.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Luka Ljubić
 */
public class DayFive implements Day {
    String instructionsPath = "src/main/resources/instructionList";
    List<String> instructionDataList = ParseUtility.ParseFromPathToList(instructionsPath);
    List<Stack<Character>> listOfCrates = new ArrayList<>();
    List<Instruction> instructionList = new ArrayList<>(parseAndFillInsructionList());


    @Override
    public void executePartOne() {

        fillCrates();

        instructionList.forEach(System.out::println);
        listOfCrates.forEach(System.out::println);

        System.out.println("----------------------------------");

        manipulateCratesWithInstructions();
        listOfCrates.forEach(System.out::println);
    }


    @Override
    public void executePartTwo() {

    }

    private void manipulateCratesWithInstructions() {
        for (Instruction instruction : instructionList) {
            for (int i = 0; i < instruction.getQuantity(); i++) {
                listOfCrates.get(instruction.getToCrate() - 1).
                        push(listOfCrates.get(instruction.getFromCrate() - 1).pop());
            }
        }
    }

    private void fillCrates() {
        listOfCrates.add(createAStackWith('Z', 'J', 'N', 'W', 'P', 'S'));
        listOfCrates.add(createAStackWith('G', 'S', 'T'));
        listOfCrates.add(createAStackWith('V', 'Q', 'R', 'L', 'H'));
        listOfCrates.add(createAStackWith('V', 'S', 'T', 'D'));
        listOfCrates.add(createAStackWith('Q', 'Z', 'T', 'D', 'B', 'M', 'J'));
        listOfCrates.add(createAStackWith('M', 'W', 'T', 'J', 'D', 'C', 'Z', 'L'));
        listOfCrates.add(createAStackWith('L', 'P', 'M', 'W', 'G', 'T', 'J'));
        listOfCrates.add(createAStackWith('N', 'G', 'M', 'T', 'B', 'F', 'Q', 'H'));
        listOfCrates.add(createAStackWith('R', 'D', 'G', 'C', 'P', 'B', 'Q', 'W'));
    }

    private Stack<Character> createAStackWith(Character... parameters) {
        List<Character> chars = Arrays.asList(parameters);
        Stack<Character> stack = new Stack<>();
        stack.addAll(chars);
        return stack;

    }

    private List<Instruction> parseAndFillInsructionList() {
        List<Instruction> instructions = new ArrayList<>();
        for (String instruction : instructionDataList) {
            instructions.add(new Instruction(instruction));
        }
        return instructions;
    }
}

package hr.bp.aoc.days.supplyStacks;

import hr.bp.aoc.days.supplyStacks.model.Instruction;
import hr.bp.aoc.util.ReaderUtil;
import hr.bp.aoc.model.Day;

import java.util.*;

/**
 * @author Luka Ljubić
 */
public class DayFive implements Day {

    //Tu mi bas paše SOUT zbog printa stackova
    String instructionsPath = "src/main/resources/instructionList";
    List<String> instructionDataList = ReaderUtil.readFromPathToList(instructionsPath);
    List<Instruction> instructionList = new ArrayList<>(parseAndFillInsructionList());



    @Override
    public void executePartOne() {


        List<Stack<Character>> listOfCrates = new ArrayList<>();
        fillCrates(listOfCrates);

        System.out.println("supplyStacks PART 1: ");
        instructionList.forEach(System.out::println);
        listOfCrates.forEach(System.out::println);

        System.out.println("----------------------------------");

        manipulateCratesWithInstructionsOneByOne(listOfCrates);
        listOfCrates.forEach(System.out::println);
    }


    @Override
    public void executePartTwo() {

        List<Stack<Character>> listOfCrates = new ArrayList<>();
        fillCrates(listOfCrates);


        System.out.println("supplyStacks PART 2: ");
        instructionList.forEach(System.out::println);
        listOfCrates.forEach(System.out::println);

        System.out.println("----------------------------------");


        manipulateCratesWithInstructionsMultipleAtOnce(listOfCrates);
        listOfCrates.forEach(System.out::println);

    }

    @Override
    public String getDayOrderNumber() {
        return "Day Five";
    }

    private void manipulateCratesWithInstructionsMultipleAtOnce(List<Stack<Character>> listOfCrates) {
        List<Character> temp = new ArrayList<>();

        for (Instruction instruction : instructionList) {
            for (int i = 0; i < instruction.getQuantity(); i++) {
                temp.add(listOfCrates.get(instruction.getFromCrate()-1).pop());
            }
            Collections.reverse(temp);
            temp.forEach(item -> listOfCrates.get(instruction.getToCrate()-1).add(item));
            temp.clear();
        }
    }

    private void manipulateCratesWithInstructionsOneByOne(List<Stack<Character>> listOfCrates) {
        for (Instruction instruction : instructionList) {
            for (int i = 0; i < instruction.getQuantity(); i++) {
                listOfCrates.get(instruction.getToCrate() - 1).
                        push(listOfCrates.get(instruction.getFromCrate() - 1).pop());
            }
        }
    }

    private void fillCrates(List<Stack<Character>> listOfCrates) {
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

package hr.bp.aoc.day1;

public class FloorReadingStrategy implements ReadingStrategy{
    @Override
    public int parseDocument(String document) {
        int finalFloor = 0; // Starting floor is the ground floor (0)
        for (char instruction : document.toCharArray()) {
            finalFloor += instructionAction(instruction);
        }
        return finalFloor;
    }

    private int instructionAction(char instruction) {
        if (instruction == '(') {
            return 1;
        } else if (instruction == ')') {
            return -1;
        } else {
            // Add exception for invalid instruction
            return 0;
        }
    }
}

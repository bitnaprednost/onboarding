package hr.bp.aoc2024.day3;

public class Command {
    private long num1;
    private long num2;
    private long resultOfMul;

    public Command(String command) {
        num1 = getNum1(command);
        num2 = getNum2(command);
        resultOfMul = setResultOfMul();
    }

    private static long getNum1(String command) {
        String leftPartOfCommand = command.split(",")[0];
        String num1String = leftPartOfCommand.split("\\(")[1];

        return Long.parseLong(num1String);
    }

    private static long getNum2(String command) {
        String rightPartOfCommand = command.split(",")[1];
        String num2String = rightPartOfCommand.split("\\)")[0];

        return Long.parseLong(num2String);
    }


    private long setResultOfMul() {
        return num1 * num2;
    }

    public long getResultOfMul() {
        return resultOfMul;
    }
}

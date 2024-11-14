package adventofcode.day01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CalibrationDocument {

    private List<String> lines;

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void setLinesFromInputString(String inputString) {
        this.lines = Arrays.asList(inputString.split("\n"));
    }
}

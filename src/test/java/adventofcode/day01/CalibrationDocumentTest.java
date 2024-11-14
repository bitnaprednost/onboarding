package adventofcode.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CalibrationDocumentTest {

    private CalibrationDocument calibrationDocument;

    @BeforeEach
    public void setUp() {
        this.calibrationDocument = new CalibrationDocument();
    }

    @Test
    public void testSettingLines() {
        List<String> inputLines = Arrays.asList("123213", "adsad11", "sdsdsd");
        calibrationDocument.setLines(inputLines);
    }

    @Test
    public void testSetLinesFromStringInput() {
        String inputString= "1ii5mgiiiiip3\njgj7mkmf8\n1131131\nffg9123i5";
        calibrationDocument.setLinesFromInputString(inputString);
    }

    @Test
    public void testSimpleInput() {
        String inputString= "1ii5mgiiiiip3\njgj7mkmf8\n1131131\nffg9123i5";
        int expectedValue = 197;

        calibrationDocument.setLinesFromInputString(inputString);
        int actualValue = calibrationDocument.calculateSumOfCalibrationValues();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSimpleInputTwo() {
        String inputString= "22\n5ttttt\na2";
        int expectedValue = 99;

        calibrationDocument.setLinesFromInputString(inputString);
        int actualValue = calibrationDocument.calculateSumOfCalibrationValues();

        Assertions.assertEquals(expectedValue, actualValue);
    }
}

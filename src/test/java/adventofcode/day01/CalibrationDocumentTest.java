package adventofcode.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CalibrationDocumentTest {
    

    @Test
    public void testCreatingNewCalibrationDocument() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("123213", "adsad11", "sdsdsd");

        Assertions.assertNotNull(calibrationDocument);
    }

    @Test
    public void testCreatingNewCalibrationDocumentWithEmptyListThrowsException() {

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            createCalibrationDocument();
        });
    }

    @Test
    public void testSimpleInput() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("1ii5mgiiiiip3","jgj7mkmf8","1131131","ffg9123i5");
        int expectedValue = 13 + 78 + 11 + 95;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSimpleInputTwo() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("22","5ttttt","a2");
        int expectedValue = 22 + 55 + 22;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testAtLeastOneLineWithoutNumbersThrowsException() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("abb5","aaeer","445tttrao02");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testOnlyOneNumberPerLine() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("aaa3","3eeijgjut","okkto9ngrjgrg","r4");

        int expectedValue = 33 + 33 + 99 + 44;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testOnlyNumbersPerLine() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("1359854","1346916","19339431","11");

        int expectedValue = 14 + 16 + 11 + 11;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testAnEmptyLine() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("1359854","","19339431","11");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testAllEmptyLines() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("","","","");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testAnEmptyInputString() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testNumbersAsLetters() {
        CalibrationDocument calibrationDocument = createCalibrationDocument("onehjgfaq4", "oneoneonetwo", "4141two", "1", "two");

        int expectedValue = 14 + 12 + 42 + 11 + 22;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    private CalibrationDocument createCalibrationDocument(String... lines) {
        return new CalibrationDocument(Arrays.asList(lines));
    }
}

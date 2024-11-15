package adventofcode.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CalibrationDocumentTest {
    

    @Test
    public void testCreatingNewCalibrationDocument() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("123213", "adsad11", "sdsdsd");

        Assertions.assertNotNull(calibrationDocument);
    }

    @Test
    public void testCreatingNewCalibrationDocumentWithEmptyListThrowsException() {

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            createSimpleCalibrationDocument();
        });
    }

    @Test
    public void testSimpleInput() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("1ii5mgiiiiip3","jgj7mkmf8","1131131","ffg9123i5");
        int expectedValue = 13 + 78 + 11 + 95;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSimpleInputTwo() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("22","5ttttt","a2");
        int expectedValue = 22 + 55 + 22;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testAtLeastOneLineWithoutNumbersThrowsException() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("abb5","aaeer","445tttrao02");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testOnlyOneNumberPerLine() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("aaa3","3eeijgjut","okkto9ngrjgrg","r4");

        int expectedValue = 33 + 33 + 99 + 44;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testOnlyNumbersPerLine() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("1359854","1346916","19339431","11");

        int expectedValue = 14 + 16 + 11 + 11;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testAnEmptyLine() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("1359854","","19339431","11");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testAllEmptyLines() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("","","","");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testAnEmptyInputString() {
        CalibrationDocument calibrationDocument = createSimpleCalibrationDocument("");

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            calibrationDocument.calculateCalibrationValuesSum();
        });
    }

    @Test
    public void testNumbersAsLetters() {
        CalibrationDocument calibrationDocument = createAdvancedCalibrationDocument("onehjgfaq4", "oneoneonetwo", "4141two", "1", "two");

        int expectedValue = 14 + 12 + 42 + 11 + 22;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }


    @Test
    public void testNumbersAsLettersTwo() {
        CalibrationDocument calibrationDocument = createAdvancedCalibrationDocument("oneoneoneoneone", "twoonetwoonetwo", "4eighthreeight", "twone1", "two");

        int expectedValue = 11 + 22 + 48 + 21 + 22;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testNumbersAsLettersThree() {
        CalibrationDocument calibrationDocument = createAdvancedCalibrationDocument("threeeee", "four1", "eght23", "one97945979684three", "1");

        int expectedValue = 33 + 41 + 23 + 13 + 11;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testNumbersAsLettersFour() {
        CalibrationDocument calibrationDocument = createAdvancedCalibrationDocument("213", "123", "2222", "9", "66767676767676767");

        int expectedValue = 23 + 13 + 22 + 99 + 67;

        int actualValue = calibrationDocument.calculateCalibrationValuesSum();

        Assertions.assertEquals(expectedValue, actualValue);
    }

    private CalibrationDocument createSimpleCalibrationDocument(String... lines) {
        CalibrationValueExtractionStrategy simpleStrategy = new SimpleCalibrationValueExtractionStrategy();

        return new CalibrationDocument(Arrays.asList(lines), simpleStrategy);
    }

    private CalibrationDocument createAdvancedCalibrationDocument(String... lines) {
        CalibrationValueExtractionStrategy simpleStrategy = new SimpleCalibrationValueExtractionStrategy();
        CalibrationValueExtractionStrategy advancedStrategy = new WordsToDigitsDecorator(simpleStrategy);

        return new CalibrationDocument(Arrays.asList(lines), advancedStrategy);
    }
}

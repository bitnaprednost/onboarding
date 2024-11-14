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
}

package hr.bp.adventofcode.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Tomičić
 */
public class LensConfigurationTest {

    @Test
    public void calculateFocusingPower_givenInputOne_returnsCorrectPower() {
        String input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        LensConfiguration lensConfiguration = new LensConfiguration(input);

        int expectedFocusingPower = 145;

        int actualFocusingPower = lensConfiguration.getFocusingPower();

        Assertions.assertEquals(expectedFocusingPower, actualFocusingPower);
    }
}

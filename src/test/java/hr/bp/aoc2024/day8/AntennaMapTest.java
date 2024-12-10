package hr.bp.aoc2024.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day8.TestUtil.*;

class AntennaMapTest {

    @Test
    void antinodesNumber_simpleInput() {
        AntennaMapParser parser = new AntennaMapParser(getSimpleInput());
        AntennaMap map = new AntennaMap(parser.parseAntennaMap());

        Assertions.assertEquals(2, map.getAntinodesNumber());
    }

    @Test
    void antinodesNumber_simpleInput_resonance() {
        AntennaMapParser parser = new AntennaMapParser(getSimpleInput());
        AntennaMap map = new AntennaMap(parser.parseAntennaMap(), true);

        Assertions.assertEquals(5, map.getAntinodesNumber());
    }

    @Test
    void antinodesNumber_input14() {
        AntennaMapParser parser = new AntennaMapParser(getInput_14());
        AntennaMap map = new AntennaMap(parser.parseAntennaMap());

        Assertions.assertEquals(14, map.getAntinodesNumber());
    }

    @Test
    void antinodesNumber_final() {
        AntennaMapParser parser = new AntennaMapParser(getInput_final());
        AntennaMap map = new AntennaMap(parser.parseAntennaMap());

        Assertions.assertEquals(369, map.getAntinodesNumber());
    }

    @Test
    void antinodesNumber_input34_resonance() {
        AntennaMapParser parser = new AntennaMapParser(getInput_14());
        AntennaMap map = new AntennaMap(parser.parseAntennaMap(), true);

        Assertions.assertEquals(34, map.getAntinodesNumber());
    }

    @Test
    void antinodesNumber_resonanceTest9_resonance() {
        AntennaMapParser parser = new AntennaMapParser(getTestResonanceInput());
        AntennaMap map = new AntennaMap(parser.parseAntennaMap(), true);

        Assertions.assertEquals(9, map.getAntinodesNumber());
    }

    @Test
    void antinodesNumber_final_resonance() {
        AntennaMapParser parser = new AntennaMapParser(getInput_final());
        AntennaMap map = new AntennaMap(parser.parseAntennaMap(), true);

        Assertions.assertEquals(1169, map.getAntinodesNumber());
    }

}
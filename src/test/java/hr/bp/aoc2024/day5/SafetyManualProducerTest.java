package hr.bp.aoc2024.day5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day5.TestUtil.getFinalInput;
import static hr.bp.aoc2024.day5.TestUtil.getTestInput;

class SafetyManualProducerTest {

    @Test
    void testInput_middleSum() {
        PageParser pageParser = new PageParser(getTestInput());
        SafetyManualProducer safetyManualProducer = new SafetyManualProducer(pageParser.getOrderingRules(),
                pageParser.getProducingOrder());

        long expected = 143;

        Assertions.assertEquals(expected, safetyManualProducer.getMiddlePageSum());
    }

    @Test
    void finalInput_middleSum() {
        PageParser pageParser = new PageParser(getFinalInput());
        SafetyManualProducer safetyManualProducer = new SafetyManualProducer(pageParser.getOrderingRules(),
                pageParser.getProducingOrder());

        long expected = 6612;

        Assertions.assertEquals(expected, safetyManualProducer.getMiddlePageSum());
    }

    @Test
    void testInput_middleSumCorrectedOrder() {
        PageParser pageParser = new PageParser(getTestInput());
        SafetyManualProducer safetyManualProducer = new SafetyManualProducer(pageParser.getOrderingRules(),
                pageParser.getProducingOrder());

        long expected = 123;

        Assertions.assertEquals(expected, safetyManualProducer.getMiddlePageSumIncorrectOrder());
    }

    @Test
    void finalInput_middleSumCorrectedOrder() {
        PageParser pageParser = new PageParser(getFinalInput());
        SafetyManualProducer safetyManualProducer = new SafetyManualProducer(pageParser.getOrderingRules(),
                pageParser.getProducingOrder());

        long expected = 4944;

        Assertions.assertEquals(expected, safetyManualProducer.getMiddlePageSumIncorrectOrder());
    }
}
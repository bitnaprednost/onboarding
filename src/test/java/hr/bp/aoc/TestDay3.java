package hr.bp.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hr.bp.aoc.day3.Day3;

public class TestDay3 {

  @Test
  public void testPart1() throws IOException {
    Day3 day3 = new Day3();

    assertEquals(7990, day3.getPart1Solution());
  }

  @Test
  public void testPart3() throws IOException {
    Day3 day3 = new Day3();

    assertEquals(2602, day3.getPart2Solution());
  }
}

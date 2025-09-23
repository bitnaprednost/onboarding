package hr.bp.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hr.bp.aoc.day4.Day4;

public class TestDay4 {

  @Test
  public void testPart1() throws IOException {
    Day4 day4 = new Day4();

    assertEquals(450, day4.getPart1Solution());
  }

  @Test
  public void testPart4() throws IOException {
    Day4 day4 = new Day4();

    assertEquals(837, day4.getPart2Solution());
  }
}

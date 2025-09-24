package hr.bp.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hr.bp.aoc.day6.Day6;

public class TestDay6 {

  @Test
  public void testPart1() throws IOException {
    Day6 day6 = new Day6();

    assertEquals(1794, day6.getPart1Solution());
  }

  @Test
  public void testPart2() throws IOException {
    Day6 day6 = new Day6();

    assertEquals(2851, day6.getPart2Solution());
  }
}

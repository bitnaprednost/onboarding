package hr.bp.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hr.bp.aoc.day5.Day5;

public class TestDay5 {

  @Test
  public void testPart5() throws IOException {
    Day5 day5 = new Day5();

    assertEquals("ZWHVFWQWW", day5.getPart1Solution());
  }

  @Test
  public void testPart2() throws IOException {
    Day5 day5 = new Day5();

    assertEquals("HZFZCCWWV", day5.getPart2Solution());
  }
}

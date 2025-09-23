package hr.bp.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hr.bp.aoc.day2.Day2;

public class TestDay2 {

  @Test
  public void testPart1() throws IOException {
    Day2 day2 = new Day2();

    assertEquals(13484, day2.getPart1Solution());
  }

  @Test
  public void testPart2() throws IOException {
    Day2 day2 = new Day2();

    assertEquals(13433, day2.getPart2Solution());
  }
}

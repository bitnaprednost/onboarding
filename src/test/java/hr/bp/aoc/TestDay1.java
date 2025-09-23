package hr.bp.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hr.bp.aoc.day1.Day1;

public class TestDay1 {

  @Test
  public void testPart1() throws IOException {
    Day1 day1 = new Day1();

    assertEquals(71023, day1.getPart1Solution());
  }

  @Test
  public void testPart2() throws IOException {
    Day1 day1 = new Day1();

    assertEquals(206289, day1.getPart2Solution());
  }
}

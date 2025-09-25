package hr.bp.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hr.bp.aoc.day7.Day7;

public class TestDay7 {

  @Test
  public void testPart1() throws IOException {
    Day7 day7 = new Day7();

    assertEquals(1307902, day7.getPart1Solution());
  }
}

package hr.bp.adventofcode.day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class SpringRowTest {

    @Test
    public void calculateDifferentArrangements_givenInputOne_returnsCorrectResult() {
        SpringRow springRow = new SpringRow("???.###".chars().mapToObj(c -> (char) c).toList(), List.of(1,1,3));

        long expectedDifferentArrangements = 1;

        long actualDifferentArrangements = springRow.getDifferentArrangements();

        Assertions.assertEquals(expectedDifferentArrangements, actualDifferentArrangements);
    }

    @Test
    public void calculateDifferentArrangements_givenInputTwo_returnsCorrectResult() {
        SpringRow springRow = new SpringRow(".??..??...?##.".chars().mapToObj(c -> (char) c).toList(), List.of(1,1,3));

        long expectedDifferentArrangements = 4;

        long actualDifferentArrangements = springRow.getDifferentArrangements();

        Assertions.assertEquals(expectedDifferentArrangements, actualDifferentArrangements);
    }

    @Test
    public void calculateDifferentArrangements_givenInputThree_returnsCorrectResult() {
        SpringRow springRow = new SpringRow("?#?#?#?#?#?#?#?".chars().mapToObj(c -> (char) c).toList(), List.of(1,3,1,6));

        long expectedDifferentArrangements = 1;

        long actualDifferentArrangements = springRow.getDifferentArrangements();

        Assertions.assertEquals(expectedDifferentArrangements, actualDifferentArrangements);
    }


    @Test
    public void calculateDifferentArrangements_givenInputFour_returnsCorrectResult() {
        SpringRow springRow = new SpringRow("????.#...#...".chars().mapToObj(c -> (char) c).toList(), List.of(4,1,1));

        long expectedDifferentArrangements = 1;

        long actualDifferentArrangements = springRow.getDifferentArrangements();

        Assertions.assertEquals(expectedDifferentArrangements, actualDifferentArrangements);
    }



    @Test
    public void calculateDifferentArrangements_givenInputFive_returnsCorrectResult() {
        SpringRow springRow = new SpringRow("????.######..#####.".chars().mapToObj(c -> (char) c).toList(), List.of(1,6,5));

        long expectedDifferentArrangements = 4;

        long actualDifferentArrangements = springRow.getDifferentArrangements();

        Assertions.assertEquals(expectedDifferentArrangements, actualDifferentArrangements);
    }

    @Test
    public void calculateDifferentArrangements_givenInputSix_returnsCorrectResult() {
        SpringRow springRow = new SpringRow("?###????????".chars().mapToObj(c -> (char) c).toList(), List.of(3,2,1));

        long expectedDifferentArrangements = 10;

        long actualDifferentArrangements = springRow.getDifferentArrangements();

        Assertions.assertEquals(expectedDifferentArrangements, actualDifferentArrangements);
    }
}

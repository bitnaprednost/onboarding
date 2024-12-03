package hr.bp.adventofcode.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Tomičić
 */
public class HashTest {

    @Test
    public void calculateHash_givenInputOne_returnsCorrectHash() {
        String input = "HASH";
        Hasher hasher = new Hasher();

        int expectedHash = 52;

        int actualHash = hasher.hash(input);

        Assertions.assertEquals(expectedHash, actualHash);
    }

    @Test
    public void calculateHash_givenInputTwo_returnsCorrectHash() {
        String input = "rn=1";
        Hasher hasher = new Hasher();

        int expectedHash = 30;

        int actualHash = hasher.hash(input);

        Assertions.assertEquals(expectedHash, actualHash);
    }

    @Test
    public void calculateHash_givenInputThree_returnsCorrectHash() {
        String input = "cm-";
        Hasher hasher = new Hasher();

        int expectedHash = 253;

        int actualHash = hasher.hash(input);

        Assertions.assertEquals(expectedHash, actualHash);
    }

    @Test
    public void calculateHash_givenInputFour_returnsCorrectHash() {
        String input = "ot=9";
        Hasher hasher = new Hasher();

        int expectedHash = 9;

        int actualHash = hasher.hash(input);

        Assertions.assertEquals(expectedHash, actualHash);
    }
}

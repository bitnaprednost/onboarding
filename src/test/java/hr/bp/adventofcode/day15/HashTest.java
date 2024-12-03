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
        Hasher hasher = new Hasher(255);

        int expectedHash = 52;

        int actualHash = hasher.hash(input, 17);

        Assertions.assertEquals(expectedHash, actualHash);
    }
}

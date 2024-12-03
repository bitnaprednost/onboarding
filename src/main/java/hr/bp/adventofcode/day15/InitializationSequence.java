package hr.bp.adventofcode.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class InitializationSequence {

    private final List<String> sequences = new ArrayList<>();

    public InitializationSequence(String input) {
        input = input.replace("\\n", "");
        sequences.addAll(Arrays.asList(input.split(",")));
    }

    public int getSumOfHashes() {
        Hasher hasher = new Hasher();
        int sum = 0;
        for (String sequence : sequences) {
            sum += hasher.hash(sequence);
        }
        return sum;
    }
}

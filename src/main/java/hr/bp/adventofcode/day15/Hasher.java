package hr.bp.adventofcode.day15;

/**
 * @author Ivan Tomičić
 */
public class Hasher {


    public Hasher() {
    }

    public int hash(String input) {
        int hashValue = 0;

        for (char c : input.toCharArray()) {

            hashValue += c;
            hashValue *= 17;
            hashValue %= 256;
        }
        return hashValue;
    }
}

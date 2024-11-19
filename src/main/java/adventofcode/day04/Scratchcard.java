package adventofcode.day04;

import java.util.Objects;
import java.util.Set;

/**
 * @author Ivan Tomičić
 */
public class Scratchcard {
    private Set<Integer> winningNumbers;
    private Set<Integer> playersNumbers;

    public Scratchcard(Set<Integer> winningNumbers, Set<Integer> playersNumbers) {
        this.winningNumbers = winningNumbers;
        this.playersNumbers = playersNumbers;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Scratchcard that)) return false;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(playersNumbers, that.playersNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, playersNumbers);
    }
}

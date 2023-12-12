package hr.bp.aoc.supply.stacks.crane;

import hr.bp.aoc.supply.stacks.Crates;

/**
 * <p>CrateMover9000 class.</p>
 *
 * @author Marko Krišković
 */
public class CrateMover9000 extends CrateMover implements Crane{
    private final Crates crates;

    public CrateMover9000(Crates crates) {
        super(crates);
        this.crates = crates;
    }
    @Override
    public void move(int amount, int from, int to) {
        for(int i=0;i<amount;i++) crates.move(from, to);
    }

}

package hr.bp.aoc.supplyStacks.crane;

import hr.bp.aoc.supplyStacks.Crates;

public class CrateMover9000 extends CrateMover implements Crane{
    private Crates crates;

    public CrateMover9000(Crates crates) {
        super(crates);
        this.crates = crates;
    }
    @Override
    public void move(int amount, int from, int to) {
        for(int i=0;i<amount;i++) crates.move(from, to);
    }

}

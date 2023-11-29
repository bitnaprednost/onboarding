package hr.bitnaPrednost.supplyStacks.crane;

import hr.bitnaPrednost.supplyStacks.Crates;

import java.util.Stack;

public class CrateMover9001 extends CrateMover implements Crane {
    private Crates crates;

    public CrateMover9001(Crates crates) {
        super(crates);
        this.crates = crates;
    }
    @Override
    public void move(int amount, int from, int to) {
        Stack<String> temp = new Stack<>();
        for(int i=0;i<amount;i++) {
            temp.push(crates.pop(from));
        }
        for(int i=0;i<amount;i++) {
            crates.push(to, temp.pop());
        }
    }
}

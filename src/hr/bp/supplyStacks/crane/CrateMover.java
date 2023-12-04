package hr.bp.supplyStacks.crane;

import hr.bp.supplyStacks.Crates;

import java.util.Arrays;

public abstract class CrateMover {
    private Crates crates;

    public CrateMover(Crates crates) {
        this.crates = crates;
    }

    public void move(int amount, int from, int to) {
        for(int i=0;i<amount;i++) crates.move(from, to);
    }

    public void parseCommand(String command) {
        int[] split = Arrays.stream(command.split("[^0-9]"))
                .filter(s->!s.equals(""))
                .mapToInt(Integer::parseInt).toArray();
        move(split[0], split[1], split[2]);
    }
}

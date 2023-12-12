package hr.bp.aoc.cathode.raytube.command;

import hr.bp.aoc.cathode.raytube.Clock;

public class Addx implements Command {
    private Clock clock;
    private Integer V;

    public Addx(Clock clock, Integer V) {
        this.clock=clock;
        this.V=V;
    }

    @Override
    public void execute() {
        clock.tick();
        clock.afterTick();
        clock.tick();
        clock.afterTick();
        clock.add(V);
    }
}

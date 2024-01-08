package hr.bp.aoc.proboscidea.volcanium.command;

import hr.bp.aoc.proboscidea.volcanium.Valve;
import hr.bp.aoc.proboscidea.volcanium.VulcanoManager;

import java.util.List;
import java.util.Optional;

/**
 * <p>Move class.</p>
 *
 * @author Marko Krišković
 */
public class Move implements Command {
    private VulcanoManager manager;
    private Valve valve;

    public Move(Valve valve, VulcanoManager manager) {
        this.manager = manager;
        this.valve = valve;
    }

    @Override
    public void execute() {
        manager.setCurrent(valve);
    }

    @Override
    public Valve getValve() {
        return valve;
    }

    @Override
    public String toString() {
        return "You move to valve " + valve.getName() + ".";
    }
}

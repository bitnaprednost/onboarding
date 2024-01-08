package hr.bp.aoc.proboscidea.volcanium.command;

import hr.bp.aoc.proboscidea.volcanium.Graph;
import hr.bp.aoc.proboscidea.volcanium.Valve;
import hr.bp.aoc.proboscidea.volcanium.VulcanoManager;

/**
 * <p>Open class.</p>
 *
 * @author Marko Krišković
 */
public class Open implements Command {
    private Valve valve;
    private VulcanoManager manager;

    public Open(Valve valve, VulcanoManager manager) {
        this.valve=valve;
        this.manager=manager;
    }

    @Override
    public void execute() {
        manager.openValve(valve);
    }

    @Override
    public Valve getValve() {
        return valve;
    }

    @Override
    public String toString() {
        return "You open valve " + valve.getName() + ".";
    }
}

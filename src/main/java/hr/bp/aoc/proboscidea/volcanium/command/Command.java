package hr.bp.aoc.proboscidea.volcanium.command;

import hr.bp.aoc.proboscidea.volcanium.Valve;

/**
 * <p>Command interface.</p>
 *
 * @author Marko Krišković
 */
public interface Command {
    void execute();
    Valve getValve();
}

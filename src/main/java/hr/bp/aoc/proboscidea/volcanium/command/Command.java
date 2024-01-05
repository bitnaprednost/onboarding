package hr.bp.aoc.proboscidea.volcanium.command;

import hr.bp.aoc.proboscidea.volcanium.Valve;

public interface Command {
    void execute();
    Valve getValve();
}

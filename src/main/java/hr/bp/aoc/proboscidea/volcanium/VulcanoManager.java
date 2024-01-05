package hr.bp.aoc.proboscidea.volcanium;

import java.util.List;

public class VulcanoManager {
    private Valve current;
    private final Graph graph;
    private long pressure;
    private long pressureReleased;

    public VulcanoManager(Graph graph, Valve startingValve) {
        this.current = startingValve;
        this.graph = graph;
        this.pressure = 0;
        this.pressureReleased = 0;
    }

    public void releasePreassure(){
        pressureReleased += pressure;
    }

    public void openValve(Valve valve) {
        pressure += valve.getRate();
        graph.setToZero(valve);
    }

    public void setCurrent(Valve current) {
        this.current=current;
    }

    public Valve getCurrent() {
        return current;
    }

    public Graph getGraph() {
        return graph;
    }

    public long getPressure() {
        return pressure;
    }

    public long getPressureReleased() {
        return pressureReleased;
    }
}

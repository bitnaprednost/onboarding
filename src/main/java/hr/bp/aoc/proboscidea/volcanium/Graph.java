package hr.bp.aoc.proboscidea.volcanium;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {
    private Set<Valve> valves;

    public Graph(Set<Valve> valves) {
        this.valves = valves;
    }

    public Optional<Valve> findValve(String name) {
        for(Valve valve : valves){
            if(valve.getName().equals(name)) return Optional.of(valve);
        }
        return Optional.empty();
    }

    public int getValvesSize() {
        return valves.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(valves, graph.valves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valves);
    }

    public void setToZero(String name) {
        Optional<Valve> valve = findValve(name);
        valve.ifPresent(value -> value.setRate(0));
    }

    public void setToZero(Valve valve) {
        setToZero(valve.getName());
    }

    public Graph copy() {
        Set<Valve> valvesCopy = valves.stream().map(Valve::copy).collect(Collectors.toSet());
        return new Graph(valvesCopy);
    }
}

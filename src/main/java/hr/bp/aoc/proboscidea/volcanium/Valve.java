package hr.bp.aoc.proboscidea.volcanium;

import java.util.Objects;
import java.util.Set;

/**
 * <p>Valve class.</p>
 *
 * @author Marko Krišković
 */
public class Valve {
    private final String name;
    private int rate;
    private final Set<String> neighbors;

    public Valve(String name, int rate, Set<String> neighbors){
        this.rate=rate;
        this.name=name;
        this.neighbors=neighbors;
    }

    public Valve copy(){
        return new Valve(name, rate, neighbors);
    }

    public String getName(){
        return name;
    }
    public int getRate(){
        return rate;
    }

    public Set<String> getNeighbors() {
        return neighbors;
    }

    public void setRate(int rate) {
        this.rate=rate;
    }

    public boolean isOpen(){
        return rate==0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valve valve = (Valve) o;
        return Objects.equals(name, valve.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

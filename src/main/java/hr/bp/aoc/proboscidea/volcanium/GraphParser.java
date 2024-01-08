package hr.bp.aoc.proboscidea.volcanium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>GraphParser class.</p>
 *
 * @author Marko Krišković
 */
public class GraphParser {

    public static Graph parseGraph(String[] lines) {
        Set<Valve> valves = new HashSet<>();

        for(String line : lines){
            if(line.matches("Valve [A-Z]{2} has flow rate=\\d+; tunnels? leads? to valves? [A-Z]{2}(, [A-Z]{2})*")){
                String name = line.substring("Valve ".length(), "Valve ".length() + 2);

                String[] split = line.split(";");
                int rate = Integer.parseInt(split[0].substring("Valve AA has flow rate=".length()));

                String otherValves = null;
                if(split[1].matches(" tunnels lead to valves [A-Z]{2}(, [A-Z]{2})+")) otherValves= split[1].substring(" tunnels lead to valves ".length());
                else if(split[1].matches(" tunnel leads to valve [A-Z]{2}")) otherValves= split[1].substring(" tunnel leads to valve ".length());

                Set<String> set = Arrays.stream(otherValves.split(", ")).collect(Collectors.toSet());

                Valve valve = new Valve(name, rate, set);
                valves.add(valve);
            }
        }

        return new Graph(valves);
    }
}

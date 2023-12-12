package hr.bp.aoc.cathode.raytube;

import hr.bp.aoc.cathode.raytube.command.Addx;
import hr.bp.aoc.cathode.raytube.command.Command;
import hr.bp.aoc.cathode.raytube.command.Noop;
import hr.bp.aoc.cathode.raytube.listener.ClockListener;
import hr.bp.aoc.cathode.raytube.listener.Listener;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class RayTube {
    private Command command;
    private Clock clock;
    private List<Integer> signals;
    private Listener listener;

    public RayTube(){
        signals = new ArrayList<>();
        listener = new ClockListener(signals);
        clock = new Clock(listener);
    }

    public void parse(String commandString) {
        Validate.notBlank(commandString);
        if(!commandString.matches("[a-x]{4}( -?\\d+)?")) throw new IllegalArgumentException("Input string not in correct format.");

        switch (commandString.substring(0, 4)){
            case "noop" -> command = new Noop(clock);
            case "addx" -> command = new Addx(clock, Integer.parseInt(commandString.substring(5)));
            default -> throw new UnsupportedOperationException("Input string not in correct format.");
        }

        excecuteCommand();
    }

    private void excecuteCommand(){
        command.execute();
        //System.out.println("Cycle:" + Clock.getCycle() + " - X:" + Clock.getX());
    }

    public int getSignalSum(){
        return signals.stream().mapToInt(i->i).sum();
    }

}

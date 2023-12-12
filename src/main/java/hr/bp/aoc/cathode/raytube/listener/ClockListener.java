package hr.bp.aoc.cathode.raytube.listener;

import java.util.List;

public class ClockListener implements Listener {
    private List<Integer> signals;
    public ClockListener(List<Integer> signals) {
        this.signals=signals;
    }

    public void update(int signal){
        signals.add(signal);
    }
}

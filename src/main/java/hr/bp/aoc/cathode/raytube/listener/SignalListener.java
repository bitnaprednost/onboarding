package hr.bp.aoc.cathode.raytube.listener;

import hr.bp.aoc.cathode.raytube.Clock;

import java.util.List;

public class SignalListener implements Listener {
    private final List<Integer> signals;
    public SignalListener(List<Integer> signals) {
        this.signals=signals;
    }

    public void update(Clock clock){
        if(((clock.getCycle())+20)%40 == 0) {
            signals.add(clock.getCycle() * clock.getX());
        }
    }
}

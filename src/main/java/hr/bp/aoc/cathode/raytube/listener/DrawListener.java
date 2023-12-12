package hr.bp.aoc.cathode.raytube.listener;

import hr.bp.aoc.cathode.raytube.Clock;

public class DrawListener implements Listener{
    private final StringBuilder stringBuilder;

    public DrawListener(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void update(Clock clock) {
        int moddedCycle = clock.getCycle() % 40;

        if(moddedCycle >= clock.getX() && moddedCycle <= clock.getX()+2) stringBuilder.append("#");
        else if(moddedCycle==0 && clock.getX()+2==40) stringBuilder.append("#");
        else stringBuilder.append(".");

        if(moddedCycle == 0) {
            stringBuilder.append("\n");
        }
    }
}

package hr.bp.aoc.cathode.raytube;

import hr.bp.aoc.cathode.raytube.listener.ClockListener;
import hr.bp.aoc.cathode.raytube.listener.Listener;

public class Clock {
    private Listener listener;
    private int cycle = 0;
    private int X = 1;

    public Clock(Listener listener) {
        this.listener = listener;
    }

    public int getCycle() {
        return cycle;
    }

    public int getX() {
        return X;
    }

    public void tick(){
        cycle++;

        if(((cycle)+20)%40 == 0) {
            listener.update(cycle*X);
            //System.out.println("Cycle:" + cycle + " - X:" + X + " - signal:" + cycle*X);
        }
    }

    public void add(int V){
        X += V;
    }
}

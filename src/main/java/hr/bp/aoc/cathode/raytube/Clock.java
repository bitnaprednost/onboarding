package hr.bp.aoc.cathode.raytube;

import hr.bp.aoc.cathode.raytube.listener.Listener;

import java.util.List;

public class Clock {
    private Listener[] listeners;
    private int cycle = 0;
    private int X = 1;

    public Clock(Listener... listeners) {
        this.listeners = listeners;
    }

    public int getCycle() {
        return cycle;
    }

    public int getX() {
        return X;
    }

    public void beforeTick(){

    }

    public void tick(){
        cycle++;

        listeners[0].update(this);
    }

    public void afterTick(){
        listeners[1].update(this);
    }

//    private void update(){
//        for(Listener listener : listeners){
//            listener.update(this);
//        }
//    }

    public void add(int V){
        X += V;
    }
}

package org.example.days.model;

/**
 * @author Luka Ljubić
 */
public class Backpack {
    private String firstCompartment;
    private String secondCompartment;

    public Backpack(String firstCompartment, String secondCompartment) {
        this.firstCompartment = firstCompartment;
        this.secondCompartment = secondCompartment;
    }
    public String combineCompartments(){
        return firstCompartment + secondCompartment;
    }

    public String getFirstCompartment() {
        return firstCompartment;
    }

    public String getSecondCompartment() {
        return secondCompartment;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "firstCompartment='" + firstCompartment + '\'' +
                ", secondCompartment='" + secondCompartment + '\'' +
                '}';
    }
}

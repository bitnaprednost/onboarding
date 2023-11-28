package org.example.days.D05_SupplyStacks.model;

/**
 * @author Luka Ljubić
 */
public class Instruction {
    private int quantity;
    private int fromCrate;
    private int toCrate;

    private final String instruction;

    public Instruction(String instruction) {
        this.instruction = instruction;
        formatStringToInstrucion();
    }

    private void formatStringToInstrucion() {
        String numbersOnly = instruction.replaceAll("[^0-9]+", "");

        if (numbersOnly.length() == 4) {
            parseIfFirstIsDoubleDigit(numbersOnly);
        } else {

            this.quantity = parseIntAt(numbersOnly, 0);
            this.fromCrate = parseIntAt(numbersOnly, 1);
            this.toCrate = parseIntAt(numbersOnly, 2);
        }

    }

    private void parseIfFirstIsDoubleDigit(String numbersOnly) {
        StringBuilder temp = new StringBuilder();
        temp.append(numbersOnly.charAt(0));
        temp.append(numbersOnly.charAt(1));

        this.quantity = Integer.parseInt(temp.toString());
        this.fromCrate = parseIntAt(numbersOnly, 2);
        this.toCrate = parseIntAt(numbersOnly, 3);
    }

    private int parseIntAt(String from, int index) {
        return Integer.parseInt(String.valueOf(from.charAt(index)));
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFromCrate() {
        return fromCrate;
    }

    public int getToCrate() {
        return toCrate;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "quantity=" + quantity +
                ", fromCrate=" + fromCrate +
                ", toCrate=" + toCrate +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}

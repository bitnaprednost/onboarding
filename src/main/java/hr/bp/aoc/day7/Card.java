package hr.bp.aoc.day7;

public enum Card {
    A(14),
    K(13),
    Q(12),
    J(11),
    T(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2);

    private final int points;

    Card(final int points) {
        this.points = points;
    }

    public static Card getCard(String symbol) {
        if (symbol.equals("A"))
            return Card.A;
        if (symbol.equals("K"))
            return Card.K;
        if (symbol.equals("Q"))
            return Card.Q;
        if (symbol.equals("J"))
            return Card.J;
        if (symbol.equals("T"))
            return Card.T;
        if (symbol.equals("9"))
            return Card.NINE;
        if (symbol.equals("8"))
            return Card.EIGHT;
        if (symbol.equals("7"))
            return Card.SEVEN;
        if (symbol.equals("6"))
            return Card.SIX;
        if (symbol.equals("5"))
            return Card.FIVE;
        if (symbol.equals("4"))
            return Card.FOUR;
        if (symbol.equals("3"))
            return Card.THREE;
        if (symbol.equals("2"))
            return Card.TWO;

        throw new IllegalArgumentException("Symbol not on the cards!");
    }

    public int getPoints() {
        return points;
    }
}

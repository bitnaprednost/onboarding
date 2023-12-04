package hr.bp.aoc.rockPaperScissors.shape;

import hr.bp.aoc.rockPaperScissors.Status;

public class ShapeClass {
    private enum ShapeEnum {
        ROCK(1), PAPER(2), SCISSORS(3);

        private final int score;
        ShapeEnum(int score) {
            this.score = score;
        }

        public int getScore() {
            return this.score;
        }

        @Override
        public String toString() {
            return "ShapeEnum{} " + super.toString();
        }
    }

    private final ShapeEnum currentMove;
    private final ShapeEnum winningMove;
    private final ShapeEnum losingMove;
    private final ShapeEnum drawingMove;

    private ShapeClass(ShapeEnum shape){
        currentMove = shape;

        if (shape.ordinal() == 0) losingMove = ShapeEnum.values()[ShapeEnum.values().length-1];
        else losingMove = ShapeEnum.values()[shape.ordinal() - 1];

        if (shape.ordinal() == 2) winningMove = ShapeEnum.values()[0];
        else winningMove = ShapeEnum.values()[shape.ordinal() + 1];

        drawingMove = ShapeEnum.values()[shape.ordinal()];
    }

    public static ShapeClass getRock(){
        ShapeEnum currentMove = ShapeEnum.ROCK;
        return new ShapeClass(currentMove);
    }

    public static ShapeClass getPaper(){
        ShapeEnum currentMove = ShapeEnum.PAPER;
        return new ShapeClass(currentMove);
    }

    public static ShapeClass getScissors(){
        ShapeEnum currentMove = ShapeEnum.SCISSORS;
        return new ShapeClass(currentMove);
    }

    public Status simulateAgainst(ShapeClass shape) {
        if (shape.currentMove.equals(winningMove)) return Status.LOSE;
        else if (shape.currentMove.equals(losingMove)) return Status.WIN;
        else if (shape.currentMove.equals(drawingMove)) return Status.DRAW;
        else throw new UnsupportedOperationException();
    }

    public ShapeEnum elfStrategy(Status status) {
        return switch (status) {
            case WIN -> winningMove;
            case LOSE -> losingMove;
            case DRAW -> drawingMove;
        };
    }
}

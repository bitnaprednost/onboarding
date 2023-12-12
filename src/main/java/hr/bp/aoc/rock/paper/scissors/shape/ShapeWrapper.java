package hr.bp.aoc.rock.paper.scissors.shape;

import hr.bp.aoc.rock.paper.scissors.Status;

/**
 * <p>ShapeClass class.</p>
 *
 * @author Marko Krišković
 */
public class ShapeWrapper {
    private enum ShapeEnum {
        ROCK(1), PAPER(2), SCISSORS(3);

        private final int score;
        ShapeEnum(int score) {
            this.score = score;
        }

        public int getScore() {
            return this.score;
        }

        public ShapeWrapper toShapeWrapper(){
            return new ShapeWrapper(this);
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

    private ShapeWrapper(ShapeEnum shape){
        currentMove = shape;

        if (shape.ordinal() == 0) losingMove = ShapeEnum.values()[ShapeEnum.values().length-1];
        else losingMove = ShapeEnum.values()[shape.ordinal() - 1];

        if (shape.ordinal() == 2) winningMove = ShapeEnum.values()[0];
        else winningMove = ShapeEnum.values()[shape.ordinal() + 1];

        drawingMove = ShapeEnum.values()[shape.ordinal()];
    }

    public ShapeEnum getShape(){
        return currentMove;
    }

    public static ShapeWrapper getRock(){
        ShapeEnum currentMove = ShapeEnum.ROCK;
        return new ShapeWrapper(currentMove);
    }

    public static ShapeWrapper getPaper(){
        ShapeEnum currentMove = ShapeEnum.PAPER;
        return new ShapeWrapper(currentMove);
    }

    public static ShapeWrapper getScissors(){
        ShapeEnum currentMove = ShapeEnum.SCISSORS;
        return new ShapeWrapper(currentMove);
    }

    public Status simulateAgainst(ShapeWrapper shape) {
        if (shape.currentMove.equals(winningMove)) return Status.LOSE;
        else if (shape.currentMove.equals(losingMove)) return Status.WIN;
        else if (shape.currentMove.equals(drawingMove)) return Status.DRAW;
        else throw new UnsupportedOperationException();
    }

    public ShapeWrapper elfStrategy(Status status) {
        return switch (status) {
            case WIN -> winningMove.toShapeWrapper();
            case LOSE -> losingMove.toShapeWrapper();
            case DRAW -> drawingMove.toShapeWrapper();
        };
    }
}

import java.util.ArrayList;

public class Player {
    private int totalScore;
    private ArrayList<String> moves;

    public Player(){
        this.totalScore = 0;
        this.moves = new ArrayList<>();
    }

    public ArrayList<String> getMoves(){
        return moves;
    }

    public int getTotalScore(){
        return totalScore;
    }

    public void addToMoves(String move){
        this.moves.add(move.toUpperCase());
    }

    public void addTotalScore(int score){
        this.totalScore += score;
    }

    @Override
    public String toString() {
        return "moves=" + moves;
    }

}


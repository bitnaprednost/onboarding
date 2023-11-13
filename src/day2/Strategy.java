package day2;

import java.util.ArrayList;
import java.util.List;

public class Strategy {
    private Game game;
    public Strategy(Game game) {
        this.game=game;
    }

    public boolean correctFormat(String input){
        return input.matches("[ABC][XYZ]");
    }

    public List<char[]> parseInputs(String input) {
        List<char[]> inputs = new ArrayList<>();

        String[] split = input.split("\n");
        for(String game : split){
            String parsedGame = game.strip().trim().replace(" ", "");
            if(correctFormat(parsedGame)) {
                inputs.add(parsedGame.toCharArray());
            }
        }
        return inputs;
    }

    public void runGames(String input) {
        List<char[]> parsedInputs = parseInputs(input);
        for (char[] round : parsedInputs) {
            game.simulateGame(round[0], round[1]);
        }
    }

    public int evaluateStrategy(){
        return game.getScore();
    }

}

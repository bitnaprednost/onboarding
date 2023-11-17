package day2;

import day2.game.Game;

import java.util.ArrayList;
import java.util.List;

public class Strategy {
    private Game game;
    public Strategy(Game game) {
        this.game=game;
    }

    private String trimWhiteSpace(String game) {
        return game.strip().trim().replace(" ", "");
    }

    private boolean checkCorrectFormat(String input){
        return input.matches("[ABC][XYZ]");
    }

    private void addToList(List<char[]> inputs, String game) {
        String parsedGame = trimWhiteSpace(game);
        if(checkCorrectFormat(parsedGame)) {
            inputs.add(parsedGame.toCharArray());
        }
    }

    private List<char[]> parseInputs(String input) {
        List<char[]> inputs = new ArrayList<>();

        String[] split = input.split("\n");
        for(String game : split){
            addToList(inputs, game);
        }
        return inputs;
    }

    public void runGames(String input) {
        game.resetScore();

        List<char[]> parsedInputs = parseInputs(input);
        for (char[] round : parsedInputs) {
            game.simulateGame(round[0], round[1]);
        }
    }

    public int evaluateStrategy(){
        return game.getScore();
    }

}

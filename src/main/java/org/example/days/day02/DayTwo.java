package org.example.days.day02;

import org.example.days.day02.model.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Luka Ljubić
 */
public class DayTwo {

    /*
    * ROCK = A = 1 point
    * PAPER = B = 2 points
    * SCISSORS = C = 3 points
    *
    * WIN = 6 Z
    * DRAW = 3 Y
    * LOSE = 0 X
    * */
    public void executeDay(){
        final String strategyGuideFilePath = "/home/user/Downloads/LUKA/Java1_Exercise0506/AdventOfCode/src/main/resources/rockPaperScissorsData.txt";
        final List<Game> games = new ArrayList<>();

        readGameDataFromFile(games, strategyGuideFilePath);
        int sum = calculateGamePointsSum(games);
        games.forEach(game -> System.out.println(game.toString()));
        System.out.println(sum);

    }
//TODO Mjenjaj Algoritam ASAP!!!!!
    private int calculateGamePointsSum(List<Game> games) {
        int sum = 0;
        for (Game game:games){
            switch (game.getPlayerTwoInput()){
                case "Z" ->{
                    if (Objects.equals(game.getPlayerOneInput(), "A")){
                        sum+=6+2;
                    } else if (Objects.equals(game.getPlayerOneInput(), "B")) {
                        sum+=6+3;
                    } else if (Objects.equals(game.getPlayerOneInput(), "C")) {
                        sum+=6+1;
                    }
                    else throw new IllegalArgumentException("Krivi simbol");
                }
                case "Y" ->{
                    if (Objects.equals(game.getPlayerOneInput(), "A")){
                        sum+=3+1;
                    } else if (Objects.equals(game.getPlayerOneInput(), "B")) {
                        sum+=3+2;
                    } else if (Objects.equals(game.getPlayerOneInput(), "C")) {
                        sum +=3+3;
                    }
                    else throw new IllegalArgumentException("Krivi simbol");
                }
                case "X" ->{
                    if (Objects.equals(game.getPlayerOneInput(), "A")){
                        sum+=0+3;
                    } else if (Objects.equals(game.getPlayerOneInput(), "B")) {
                        sum+=0+1;
                    } else if (Objects.equals(game.getPlayerOneInput(), "C")) {
                        sum+=0+2;
                    }
                    else throw new IllegalArgumentException("Krivi simbol");
                }
                default -> throw new IllegalStateException("Unexpected value: " + game.getPlayerTwoInput());
            }
        }
        return sum;
    }

    private void readGameDataFromFile(List<Game> games, String strategyGuideFilePath) {
        try(Scanner scanner = new Scanner(new File(strategyGuideFilePath))){
            scanner.useDelimiter(" ");

            String playerOne;
            String playerTwo;
            while (scanner.hasNext()){
                playerOne = scanner.next().trim();
                playerTwo = scanner.nextLine().trim();

                games.add(new Game(playerOne, playerTwo));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

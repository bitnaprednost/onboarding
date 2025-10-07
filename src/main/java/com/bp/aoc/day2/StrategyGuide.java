package com.bp.aoc.day2;

import java.util.ArrayList;
import java.util.Scanner;

public class StrategyGuide {

    /*Scanner to scan the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args){

        Player opponent = new Player();
        Player player = new Player();
        ArrayList<String> endOfRounds = new ArrayList<>();
        int result = 0;

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        try(Scanner scanner = new Scanner(RockPaperScissors.class.getClassLoader().getResourceAsStream(nameOfTheFile))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                line = line.replaceAll("\\s", "");

                /*If there is something else beside two characters inside the line it throws an error*/
                if(line.length() != 2){
                    throw new IllegalArgumentException("Error: Line must contain two characters");
                }

                opponent.addToMoves(String.valueOf(line.charAt(0)));
                endOfRounds.add(String.valueOf(line.charAt(1)));

            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }


        result = tournament(opponent, player, endOfRounds);
        if(result > 0){
            System.out.println("You won with score of " + player.getTotalScore());
        }
        else if(result == 0){
            System.out.println("The game ended in a tie and your score was " + player.getTotalScore());
        }
        else{
            System.out.println("Your opponent won and your score was " + player.getTotalScore());
        }

    }

    public static int tournament(Player playerOne, Player playerTwo, ArrayList<String> endOfRounds){

        /*Rock = 1
        Paper = 2
        Scissors = 3 */
        for(int i = 0; i < playerOne.getMoves().size(); i++){
            String endOfRound = endOfRounds.get(i);
            int moveOne = getNumberFromMove(playerOne.getMoves().get(i));

            /*if it's a draw then score should be 3 + points from the move (same as player one since it's a draw)*/
            if(endOfRound.contains("Y")){
                System.out.println("Round #" + i + " is a draw");
                playerOne.addTotalScore(3 + moveOne);
                playerTwo.addTotalScore(3 + moveOne);
            }
            /*if it's your win then it's should be 6 + points from the move*/
            else if(endOfRound.contains("Z")){
                System.out.println("You won round #" + i);
                playerOne.addTotalScore(moveOne);

                /*if it's scissors then the points from the move is 1 otherwise it's moveOne + 1*/
                int score = (moveOne == 3) ? 1 : (moveOne + 1);
                playerTwo.addTotalScore(6 + score);
            }
            else if(endOfRound.contains("X")){
                System.out.println("You lost round #" + i);
                playerOne.addTotalScore(6 + moveOne);

                /*if it's rock then the points from the move is 3 otherwise it's moveOne - 1*/
                int score = (moveOne == 1) ? 3 : (moveOne - 1);
                playerTwo.addTotalScore(score);
            }

        }

        return playerTwo.getTotalScore() - playerOne.getTotalScore();
    }

    public static int getNumberFromMove(String character){
        return switch(character){
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            default -> 0;
        };
    }
}

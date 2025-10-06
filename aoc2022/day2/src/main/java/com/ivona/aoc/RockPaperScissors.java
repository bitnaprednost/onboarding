package com.ivona.aoc;

import java.util.Scanner;

public class RockPaperScissors {

    /*Scanner to scan the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args){

        Player opponent = new Player();
        Player player = new Player();
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
                player.addToMoves(String.valueOf(line.charAt(1)));

            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        result = tournament(opponent, player);

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

    public static int tournament(Player playerOne, Player playerTwo){

        /*Rock = 1
        Paper = 2
        Scissors = 3 */
        for(int i = 0; i < playerOne.getMoves().size(); i++){

            int moveOne = getNumberFromMove(playerOne.getMoves().get(i));
            int moveTwo = getNumberFromMove(playerTwo.getMoves().get(i));
            int difference = moveTwo - moveOne;

            /*Difference between points from moves is 0*/
            if(difference == 0){
                System.out.println("Round #" + i + " is a draw");
                playerOne.addTotalScore(3 + moveOne);
                playerTwo.addTotalScore(3 + moveTwo);
            }
            /*Difference between points from moves is either -2 or 1*/
            else if(difference == -2 || difference == 1){
                System.out.println("You won round #" + i);
                playerOne.addTotalScore(moveOne);
                playerTwo.addTotalScore(6 + moveTwo);

            }
            /*Difference between points from moves is either 2 or -1*/
            else if(difference == 2 || difference == -1){
                System.out.println("You lost round #" + i);
                playerOne.addTotalScore(6 + moveOne);
                playerTwo.addTotalScore(moveTwo);
            }

        }

        return playerTwo.getTotalScore() - playerOne.getTotalScore();
    }

    public static int getNumberFromMove(String character){
        return switch(character){
            case "A", "X" -> 1;
            case "B", "Y" -> 2;
            case "C", "Z" -> 3;
            default -> 0;
        };
    }
}

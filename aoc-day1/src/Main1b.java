import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1b {

    /*Scanner to read the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args) {
        int calories = 0;
        int total = 0;
        /*ArrayList of instances of record Elf(it contains the number of calories)*/
        ArrayList<Elf> elves = new ArrayList<>();

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        try(Scanner scanner = new Scanner(new File(nameOfTheFile))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                /*If the line is not blank then it adds the calories to that elf*/
                if(!line.isBlank()){
                    calories += Integer.parseInt(line);
                }
                /*Otherwise it creates a new element for the ArrayList and sets the calories to zero*/
                else if(calories > 0){
                    sortedAdd(elves, calories);
                    calories = 0;
                }
            }

            /*Checking if there are only more blank lines at the end of the file or not*/
            if(calories > 0){
                sortedAdd(elves, calories);
            }

        }catch(IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
        }

        /*Printing elves and the number of calories*/
        for(Elf elf: elves){
            System.out.println("Elf #" + (elves.indexOf(elf) + 1) + " " + elf);
        }


        /*Calculating the total and printing the first three elves who have the largest number of calories*/
        for(int i = 0; i < 3; i++){
            total += elves.get(i).numberOfCalories();
        }
        System.out.println("The top three elves carrying the most calories are in total carrying: " + total);

    }


    /*sorted input in order to retrieve the first three elements*/
    private static void sortedAdd(ArrayList<Elf> elves, int calories){
        int i = 0;
        while (i < elves.size() && elves.get(i).numberOfCalories() > calories) {
            i++;
        }

        elves.add(i, new Elf(calories));
    }

}
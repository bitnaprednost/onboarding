import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main1a {

    /*Scanner to read the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args){

        int calories = 0;
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
                    elves.add(new Elf(calories));
                    calories = 0;
                }
            }

            /*Checking if there are only more blank lines at the end of the file or not*/
            if(calories > 0){
                elves.add(new Elf(calories));
            }

        }catch(IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
        }

        /*Printing elves and the number of calories*/
        for(Elf elf: elves){
            System.out.println("Elf #" + (elves.indexOf(elf) + 1) + " " + elf);
        }


        /*Printing the elf with the maximum number of calories*/
        System.out.println("The elf with maximum number of calories which is " + getMaximumCaloriesElf(elves).numberOfCalories() + " is elf number #" + (elves.indexOf(getMaximumCaloriesElf(elves)) + 1)) ;

    }

    /*returning the elf with the maximum number of calories to get its index in the ArrayList*/
    private static Elf getMaximumCaloriesElf(ArrayList<Elf> elves){
        Elf maximumCaloriesElf = elves.get(0);

        for(Elf elf: elves){
            if(elf.numberOfCalories() >= maximumCaloriesElf.numberOfCalories()){
                maximumCaloriesElf = elf;
            }
        }

        return maximumCaloriesElf;
    }
}
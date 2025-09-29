import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main3a {

    /*Using the difference of Unicode value and priority*/
    public static final int differenceFromUppercase = 38;
    public static final int differenceFromLowercase = 96;

    /*Scanner to scan the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

   public static void main(String[] args){
       int sumOfPriorities = 0;

       System.out.println("Enter the name of the file:");
       String nameOfTheFile = scannerFileName.nextLine();

       try(Scanner scanner = new Scanner(new File(nameOfTheFile))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
                sumOfPriorities += reorganization(line);
            }
       }catch(IOException ioe){
           System.out.println("Error: " + ioe.getMessage());
       }

       System.out.println(sumOfPriorities);
   }

   public static int reorganization(String line){
       int priority = 0;
       int mid = line.length() / 2;
       String duplicates = "";

       String firstCompartment = line.substring(0, mid);
       String secondCompartment = line.substring(mid);

       System.out.println(firstCompartment);
       System.out.println(secondCompartment);

       for(int i = 0; i < firstCompartment.length(); i++){
           char letter = firstCompartment.charAt(i);
           if(secondCompartment.indexOf(letter) != -1 && duplicates.indexOf(letter) == -1){
               duplicates += letter;
                if(Character.isUpperCase(letter)){
                    priority = (letter - differenceFromUppercase);
                }
                else{
                    priority += (letter - differenceFromLowercase);
                }
           }
       }

       return priority;
   }
}
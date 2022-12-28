import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RockPaperScissors {


    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day2/inputday2.txt";
        String input = readFile(filePath);
        //System.out.println(input);

        int firstScore = 0;
        int secondScore=0;
    
        
        for (String s : input.split("\n")) {
            //System.out.println(s);
            s.trim();
            if(s.charAt(0)=='A' && s.charAt(2)=='X'){
                firstScore+=1+3;
                secondScore+=0+3;
            }else if(s.charAt(0)=='A' && s.charAt(2)=='Y'){
                firstScore+=2+6;
                secondScore+=3+1;
            }else if(s.charAt(0)=='A' && s.charAt(2)=='Z'){
                firstScore+=3+0;
                secondScore+=6+2;
            }else if(s.charAt(0)=='B' && s.charAt(2)=='X'){
                firstScore+=1+0;
                secondScore+=0+1;
            }else if(s.charAt(0)=='B' && s.charAt(2)=='Y'){
                firstScore+=2+3;
                secondScore+=3+2;
            }else if(s.charAt(0)=='B' && s.charAt(2)=='Z'){
                firstScore+=3+6;
                secondScore+=6+3;
            }else if(s.charAt(0)=='C' && s.charAt(2)=='X'){
                firstScore+=1+6;
                secondScore+=0+2;
            }else if(s.charAt(0)=='C' && s.charAt(2)=='Y'){
                firstScore+=2+0;
                secondScore+=3+3;
            }else if(s.charAt(0)=='C' && s.charAt(2)=='Z'){
                firstScore+=3+3;
                secondScore+=6+1;
            }

            }
        
        System.out.println(firstScore);
        System.out.println(secondScore);

        
    }

    private static String readFile(String file_path) {

        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(file_path)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return string;
    }

}
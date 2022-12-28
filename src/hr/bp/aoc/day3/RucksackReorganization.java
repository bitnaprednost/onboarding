import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RucksackReorganization {


    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day3/inputday3.txt";
        String input = readFile(filePath);
        //System.out.println(input);


        //first part
        ArrayList<Character> inBothCompartment = new ArrayList<Character>();
        for (String s : input.split("\n")) {
            //System.out.println(s);
            s.trim();
            boolean duplicate = false;
            for (int i = 0; i <= (s.length() / 2 - 1); i++) {
                for (int j = s.length() / 2; j < s.length(); j++) {
                    if (Character.compare(s.charAt(i), s.charAt(j)) == 0) {
                        inBothCompartment.add(s.charAt(i));
                        //System.out.println(s.charAt(i));
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    break;
                }
            }
        }

        int sumPriorities = 0;

        for (Character character : inBothCompartment) {
            //System.out.println(character);
            //System.out.println((int) character-(int)('a')+1);
            if (character >= 'a' && character <= 'z') {
                sumPriorities += (int) character - (int) ('a') + 1;
            } else if (character >= 'A' && character <= 'Z') {
                sumPriorities += (int) character - (int) ('A') + 1 + 26;
            }

        }

        System.out.println(sumPriorities);


        //Second part
        String[] rucksack = input.split("\n");

        ArrayList<Character> inThreeRucksack = new ArrayList<Character>();
        boolean inThree = false;

        for (int i = 0; i <= rucksack.length - 1 - 2; i += 3) {
            //System.out.println(rucksack[i]);
            String s1 = rucksack[i];
            String s2 = rucksack[i + 1];
            String s3 = rucksack[i + 2];

            for (int j = 0; j < s1.length(); j++) {
                for (int k = 0; k < s2.length(); k++) {
                    for (int l = 0; l < s3.length(); l++) {
                        if ((Character.compare(s1.charAt(j), s2.charAt(k)) == 0) && (Character.compare(s2.charAt(k), s3.charAt(l)) == 0)) {
                            inThreeRucksack.add(s1.charAt(j));
                            inThree = true;
                            break;
                        }
                    }
                    if (inThree) {
                        break;
                    }
                }
                if (inThree) {
                    s1 = "";
                    s2 = "";
                    s3 = "";
                    inThree = false;
                }
            }

        }
        int sumBadges = 0;
        for (Character character : inThreeRucksack) {
            //System.out.println(character);
            //System.out.println((int) character-(int)('a')+1);
            if (character >= 'a' && character <= 'z') {
                sumBadges += (int) character - (int) ('a') + 1;
            } else if (character >= 'A' && character <= 'Z') {
                sumBadges += (int) character - (int) ('A') + 1 + 26;
            }

        }

        System.out.println(sumBadges);


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
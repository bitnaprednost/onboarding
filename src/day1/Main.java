package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    private static String getTextFromFile(String file) throws IOException {
        String everything = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }

        return everything;
    }

    public static void main(String args[]) throws IOException {
        ElfManager manager = new ElfManager();
        List<Elf> elves = manager.createElves(getTextFromFile("Resources/day1Data.txt"));
        List<Elf> elfMostCalories = manager.getElfMostCalories(elves, 3);

        System.out.println(manager.sumCalories(elfMostCalories));
    }
}

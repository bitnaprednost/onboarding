package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    public static String getTextFromFile(String file) throws IOException {
        String everything = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            sb.deleteCharAt(sb.lastIndexOf("\n"));
            everything = sb.toString();
        }

        return everything;
    }
}

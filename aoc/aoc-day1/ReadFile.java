import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public String readFile(String filename) {
        StringBuilder data = new StringBuilder();

        // Read from file if it exists
        try
        {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                data.append(myReader.nextLine()).append(System.lineSeparator());
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        // Return content as a single string
        return data.toString().trim();
    }
}

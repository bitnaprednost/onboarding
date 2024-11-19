package day1;

public class CalibrationSumWithSpelling {
    public int calibrationSumWithSpelling (String calib_document) {
        int totalSum = 0;

        // Split the file content into lines
        String[] lines = calib_document.split(System.lineSeparator());

        // Define the number words
        String[] numberWords = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        // Process each line
        for (String line : lines)
        {
            Integer firstDigit = null;
            Integer lastDigit = null;

            // For each word in the line, check for number words
            int i = 0;
            while (i < line.length())
            {
                // Try matching known number words
                boolean matched = false;
                for (String word : numberWords)
                {
                    // If the substring starting at index i matches a number word
                    if (line.startsWith(word, i))
                    {
                        int digit = wordToDigit(word);
                        if (firstDigit == null)
                        {
                            firstDigit = digit;
                        }
                        lastDigit = digit;
                        i += word.length()-1; // Move index forward by the length of the matched word
                        matched = true;
                        break;
                    }
                }

                // If no match is found, check for a digit
                if (!matched && Character.isDigit(line.charAt(i)))
                {
                    int digit = Character.getNumericValue(line.charAt(i));
                    if (firstDigit == null)
                    {
                        firstDigit = digit;
                    }
                    lastDigit = digit;
                    i++; // Move to the next character
                }
                // If neither a digit nor a valid word is found, just move to the next character
                else if (!matched)
                {
                    i++;
                }
            }

            // If both first and last digits were found, calculate the two-digit number
            if (firstDigit != null && lastDigit != null)
            {
                int calibrationValue = firstDigit * 10 + lastDigit;
                totalSum += calibrationValue;
            }
        }
        // Return the total sum
        return totalSum;
    }

    // Helper method to map words to digits
    private Integer wordToDigit(String word) {
        switch (word.toLowerCase()) {
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return null; // Not a valid digit
        }
    }
}
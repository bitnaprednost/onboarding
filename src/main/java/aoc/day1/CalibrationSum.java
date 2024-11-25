package aoc.day1;

public class CalibrationSum {
    public int calibrationSum (String calib_document) {
        int totalSum = 0;

        // Split the file content into lines
        String[] lines = calib_document.split(System.lineSeparator());

        // Process each line
        for (String line : lines)
        {
            int firstDigit = -1;
            int lastDigit = -1;

            // Extract first and last digits
            for (char c : line.toCharArray())
            {
                if (Character.isDigit(c))
                {
                    if (firstDigit == -1)
                    {
                        // First digit found
                        firstDigit = Character.getNumericValue(c);
                    }
                    // Update last digit
                    lastDigit = Character.getNumericValue(c);
                }
            }

            // If both digits were found, calculate the two-digit number
            if (firstDigit != -1 && lastDigit != -1)
            {
                int calibrationValue = firstDigit * 10 + lastDigit;
                totalSum += calibrationValue;
            }
        }

        // Return the total sum
        return totalSum;

    }
}

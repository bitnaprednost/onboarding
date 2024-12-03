package aoc_2024.day3;

import java.util.regex.*;

public class MulSequenceWithEnable extends MulSequence {

    @Override
    protected int findMatches (Matcher m){
        boolean insideDont = false;
        int sum = 0;

        while (m.find())
        {
            if (m.group().equals("do()"))
            {
                // Found do(), turn off ignore mode
                insideDont = false;
            }
            else if (m.group().equals("don't()"))
            {
                // Found don't(), turn on ignore mode
                insideDont = true;
            }
            else
            {
                if (!insideDont)
                {
                    int firstValue = Integer.parseInt(m.group(1));  // First captured value
                    int secondValue = Integer.parseInt(m.group(2)); // Second captured value

                    sum += firstValue*secondValue;

                }
            }
        }
        return sum;
    }
}

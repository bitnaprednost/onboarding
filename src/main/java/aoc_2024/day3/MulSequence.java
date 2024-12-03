package aoc_2024.day3;

import java.util.regex.*;

public class MulSequence {
    public int findMulSequence (String CorruptedMemory, String pattern){

        Pattern mul = Pattern.compile(pattern);
        Matcher m = mul.matcher(CorruptedMemory);

        // Find all matches
        return findMatches(m);
    }

    protected int findMatches (Matcher m){
        int sum = 0;
        while (m.find())
        {
            int firstValue = Integer.parseInt(m.group(1));  // First captured value
            int secondValue = Integer.parseInt(m.group(2)); // Second captured value

            sum += firstValue*secondValue;
        }
        return sum;
    }
}

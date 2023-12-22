package hr.bp.aoc.rock.paper.scissors;

import hr.bp.aoc.util.Reader;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>ParserDay2 class.</p>
 *
 * @author Marko Krišković
 */
public class ReaderDay2 implements Reader {

    private ReaderDay2(){}

    private static String trimWhiteSpace(String game) {
        return game.strip().trim().replace(" ", "");
    }

    private static boolean checkCorrectFormat(String input){
        return input.matches("[ABC][XYZ]");
    }

    public static List<char[]> parseInputs(String[] inputs) {
        List<char[]> list = new ArrayList<>();

        for(String input : inputs){
            input = trimWhiteSpace(input);
            Validate.isTrue(checkCorrectFormat(input));
            list.add(input.toCharArray());
        }

        return list;
    }
}

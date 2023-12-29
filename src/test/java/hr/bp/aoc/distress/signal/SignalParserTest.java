package hr.bp.aoc.distress.signal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SignalParserTest {

    @Test
    void canParseIntoPairs(){
        String text = """
                [7,7,7,7]
                [7,7,7]
                
                [[4,4],4,4]
                [[4,4],4,4,4]
                
                []
                [3]
                
                [[[]]]
                [[]]
                """;

        List<Object[]> list = new ArrayList<>();
        Object[] temp = new Object[] {List.of(7,7,7,7), List.of(7,7,7)};
        list.add(temp);
        temp = new Object[] {List.of(List.of(4,4), 4, 4), List.of(List.of(4,4), 4, 4, 4)};
        list.add(temp);
        temp = new Object[] {new ArrayList<>(), List.of(3)};
        list.add(temp);
        temp = new Object[] {List.of(List.of(new ArrayList<>())), List.of(new ArrayList<>())};
        list.add(temp);

        List<Object[]> result = SignalParser.stringToCommands(text);

        assertEquals(4, result.size());

        assertEquals(list.get(0)[0], result.get(0)[0]);
        assertEquals(list.get(0)[1], result.get(0)[1]);
        assertEquals(list.get(1)[0], result.get(1)[0]);
        assertEquals(list.get(1)[1], result.get(1)[1]);
        assertEquals(list.get(2)[0], result.get(2)[0]);
        assertEquals(list.get(2)[1], result.get(2)[1]);
        assertEquals(list.get(3)[0], result.get(3)[0]);
        assertEquals(list.get(3)[1], result.get(3)[1]);
    }

    @Test
    void canSumAllCorrectlyOrderedSignals(){
        String text = """
                [1,1,3,1,1]
                [1,1,5,1,1]
                
                [[1],[2,3,4]]
                [[1],4]
                
                [9]
                [[8,7,6]]
                
                [[4,4],4,4]
                [[4,4],4,4,4]
                
                [7,7,7,7]
                [7,7,7]
                
                []
                [3]
                
                [[[]]]
                [[]]
                
                [1,[2,[3,[4,[5,6,7]]]],8,9]
                [1,[2,[3,[4,[5,6,0]]]],8,9]
                """;

        List<Object[]> commands = SignalParser.stringToCommands(text);

        int sum = SignalParser.sumCorrectSignals(commands);

        assertEquals(13, sum);
    }

    @Test
    void canSortElements(){
        String text = """
                [1,1,3,1,1]
                [1,1,5,1,1]
                
                [[1],[2,3,4]]
                [[1],4]
                
                [9]
                [[8,7,6]]
                
                [[4,4],4,4]
                [[4,4],4,4,4]
                
                [7,7,7,7]
                [7,7,7]
                
                []
                [3]
                
                [[[]]]
                [[]]
                
                [[2]]
                [[6]]
                """;

        List<Object> list = new ArrayList<>();

        list.add(new ArrayList<>());
        list.add(List.of(new ArrayList<>()));
        list.add(List.of(List.of(new ArrayList<>())));
        list.add(List.of(1,1,3,1,1));
        list.add(List.of(1,1,5,1,1));
        list.add(List.of(List.of(1),List.of(2,3,4)));
        list.add(List.of(List.of(1),4));
        list.add(List.of(List.of(2)));
        list.add(List.of(3));
        list.add(List.of(List.of(4,4),4,4));
        list.add(List.of(List.of(4,4),4,4,4));
        list.add(List.of(List.of(6)));
        list.add(List.of(7,7,7));
        list.add(List.of(7,7,7,7));
        list.add(List.of(List.of(8,7,6)));
        list.add(List.of(9));

        List<Object[]> commands = SignalParser.stringToCommands(text);
        List<Object> result = SignalParser.sortSignals(commands);

        assertEquals(list.size(), result.size());
        for(int i=0;i<list.size();i++){
            assertEquals(list.get(i), result.get(i));
        }
    }

    @Test
    void canCalculateDecoredKey(){
        String text = """
                [1,1,3,1,1]
                [1,1,5,1,1]
                
                [[1],[2,3,4]]
                [[1],4]
                
                [9]
                [[8,7,6]]
                
                [[4,4],4,4]
                [[4,4],4,4,4]
                
                [7,7,7,7]
                [7,7,7]
                
                []
                [3]
                
                [[[]]]
                [[]]
                
                [[2]]
                [[6]]
                """;

        List<Object[]> commands = SignalParser.stringToCommands(text);
        List<Object> sorted = SignalParser.sortSignals(commands);

        Object token1 = List.of(List.of(2));
        Object token2 = List.of(List.of(6));
        long product = SignalParser.calculateDecoderKey(sorted, token1, token2);

        assertEquals(96, product);
    }

}
package hr.bp.aoc.distress.signal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SignalComparatorTest {

    @Test
    void canCompareTwoIntegers(){
        Integer integer1 = 1;
        Integer integer2 = 3;

        assertTrue(SignalComparator.compareIntegers(integer1, integer2).get());
        assertFalse(SignalComparator.compareIntegers(integer2, integer1).get());
        assertEquals(Optional.empty(), SignalComparator.compareIntegers(integer1, integer1));
    }

    @Test
    void canCompareTwoListsDifferentLength(){
        List<Integer> list1 = List.of(1,1,3,1,1);
        List<Integer> list2 = List.of(1,1,3);

        assertFalse(SignalComparator.compareLists(list1, list2).get());
        assertTrue(SignalComparator.compareLists(list2, list1).get());
        assertEquals(Optional.empty(), SignalComparator.compareLists(list1, list1));
    }

    @Test
    void canCompareTwoListsSameLength(){
        List<Integer> list1 = List.of(1,1,3);
        List<Integer> list2 = List.of(1,1,5);

        assertTrue(SignalComparator.compareLists(list1, list2).get());
        assertFalse(SignalComparator.compareLists(list2, list1).get());
        assertEquals(Optional.empty(), SignalComparator.compareLists(list1, list1));
    }

    @Test
    void canCompareOneIntegerOneList(){
        Integer integer = 1;
        List<Integer> list = List.of(3);

        assertTrue(SignalComparator.compareIntegerList(integer, list).get());
        assertFalse(SignalComparator.compareListInteger(list, integer).get());
    }

    @Test
    void canCompareOneIntegerOneListMultipleElements(){
        Integer integer = 1;
        List<Integer> list = List.of(1, 3);

        assertTrue(SignalComparator.compareIntegerList(integer, list).get());
        assertFalse(SignalComparator.compareListInteger(list, integer).get());
    }

    @Test
    void canCompareOneIntegerOneListNoElements(){
        Integer integer = 1;
        List<Integer> list = new ArrayList<>();

        assertFalse(SignalComparator.compareIntegerList(integer, list).get());
        assertTrue(SignalComparator.compareListInteger(list, integer).get());
    }

    @Test
    void canCompareChainList(){
        List<List<Integer>> list1 = List.of(List.of(1), List.of(2,3,4));
        List<?> list2 = List.of(List.of(1), Integer.valueOf(4));

        assertTrue(SignalComparator.compareLists(list1, list2).get());
        assertFalse(SignalComparator.compareLists(list2, list1).get());
    }

    @Test
    void canCompareChainListNoElements(){
        List<List<List<Integer>>> tripleList = List.of(List.of(new ArrayList<>()));
        List<List<Integer>> doubleList = List.of(new ArrayList<>());

        assertFalse(SignalComparator.compareLists(tripleList, doubleList).get());
        assertTrue(SignalComparator.compareLists(doubleList, tripleList).get());
    }
}
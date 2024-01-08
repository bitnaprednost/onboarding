package hr.bp.aoc.distress.signal;

import java.util.*;

/**
 * <p>SignalComparator class.</p>
 *
 * @author Marko Krišković
 */
public class SignalComparator implements Comparator<Object> {

    public static Optional<Boolean> compareIntegers(Integer integer1, Integer integer2) {
        if(integer1.equals(integer2)) return Optional.empty();

        return Optional.of(integer1.compareTo(integer2) < 0);
    }

    public static <T, V> Optional<Boolean> compareLists(List<T> list1, List<V> list2) {
        Iterator<T> iterator1 = list1.iterator();
        Iterator<V> iterator2 = list2.iterator();

        while(iterator1.hasNext() || iterator2.hasNext()){
            if(!iterator1.hasNext()) return Optional.of(true);
            if(!iterator2.hasNext()) return Optional.of(false);

            T next1 = iterator1.next();
            V next2 = iterator2.next();

            Optional<Boolean> optionalCompare = compareObjects(next1, next2);

            if(optionalCompare.isPresent()) return optionalCompare;
        }

        return Optional.empty();
    }

    public static <T> Optional<Boolean> compareIntegerList(Integer integer, List<T> list) {
        return compareLists(List.of(integer), list);
    }

    public static <T> Optional<Boolean> compareListInteger(List<T> list, Integer integer) {
        return compareLists(list, List.of(integer));
    }

    public static <T,V> Optional<Boolean> compareObjects(Object o1, Object o2) {
        if(o1 instanceof List<?>){
            if(o2 instanceof List<?>) return compareLists((List<T>) o1, (List<V>) o2);
            else return compareListInteger((List<T>) o1, (Integer) o2);
        }
        else{
            if(o2 instanceof List<?>) return compareIntegerList((Integer) o1, (List<V>) o2);
            else return compareIntegers((Integer) o1, (Integer) o2);
        }
    }

    @Override
    public int compare(Object o1, Object o2) {
        Optional<Boolean> optional = compareObjects(o1, o2);

        if(optional.isEmpty()) return 0;
        else if(optional.get().equals(Boolean.TRUE)) return -1;
        else return 1;
    }
}

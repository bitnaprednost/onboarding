package hr.bp.aoc.distress.signal;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class IntegerComparator {

    public static Optional<Boolean> compare(Integer integer1, Integer integer2) {
        if(integer1.equals(integer2)) return Optional.empty();

        return Optional.of(integer1.compareTo(integer2) < 0);
    }

    public static <T, V> Optional<Boolean> compare(List<T> list1, List<V> list2) {
        Iterator<T> iterator1 = list1.iterator();
        Iterator<V> iterator2 = list2.iterator();

        while(iterator1.hasNext() || iterator2.hasNext()){
            if(!iterator1.hasNext()) return Optional.of(true);
            if(!iterator2.hasNext()) return Optional.of(false);

            T next1 = iterator1.next();
            V next2 = iterator2.next();

            Optional<Boolean> optionalCompare = compare(next1, next2);

            if(optionalCompare.isPresent()) return optionalCompare;
        }

        return Optional.empty();
    }

    public static <T> Optional<Boolean> compare(Integer integer, List<T> list) {
        return compare(List.of(integer), list);
    }

    public static <T> Optional<Boolean> compare(List<T> list, Integer integer) {
        return compare(list, List.of(integer));
    }

    public static <T,V> Optional<Boolean> compare(Object next1, Object next2) {
        if(next1 instanceof List<?>){
            if(next2 instanceof List<?>) return compare((List<T>) next1, (List<V>) next2);
            else return compare((List<T>) next1, (Integer) next2);
        }
        else{
            if(next2 instanceof List<?>) return compare((Integer) next1, (List<V>) next2);
            else return compare((Integer) next1, (Integer) next2);
        }
    }
}

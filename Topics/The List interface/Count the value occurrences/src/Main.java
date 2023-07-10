import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class Counter {
    HashSet
    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        return Collections.frequency(list1, elem) == Collections.frequency(list2, elem);
    }
}
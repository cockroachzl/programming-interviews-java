import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Using immutable collections, generic, generics with PECS principle
 */
public class Subsets {
    /**
     * Recursively add all subsets(0,n-1) = { (element 0, subsets(1, n-1)}, subsets(1, n-1)}
     * @param set
     * @param <E>
     * @return
     */
    public <E> List<List<E>> getAllSubsets(List<E> set) {
        if (set.size() == 0) {
            List<List<E>> ret = new ArrayList<List<E>>();
            ret.add(Collections.<E>emptyList());
            return ret;
        }
        E firstElement = set.get(0);
        List<E> tailElements = set.subList(1, set.size());
        List<List<E>> subsets1 = getAllSubsets(tailElements);
        List<List<E>> subsets2 = insertAll(firstElement, subsets1);
        return concat(subsets1, subsets2);
    }

    /**
     * Insert element to all lists and generate a new lists
     * @param element
     * @param lists immutable
     * @param <E>
     * @return
     */
    private <E> List<List<E>> insertAll(E element, List<List<E>> lists) {
        List<List<E>> ret = new ArrayList<>();
        for (List<E> list : lists) {
            List<E> newList = new ArrayList<>();
            newList.add(element);
            newList.addAll(list);
            ret.add(newList);
        }
        return ret;
    }

    private <E> List<List<E>> concat(List<List<E>> list0, List<List<E>> list1) {
        List<List<E>> ret = new ArrayList<>(list0);
        ret.addAll(list1);
        return ret;
    }
}

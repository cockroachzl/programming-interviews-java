import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liang on 2/16/2016.
 */
public class SubsetsTest {

    private Subsets subsets;
    private List<Integer> set;
    @Before
    public void setup() {
        subsets = new Subsets();
        set = Arrays.asList(1, 2, 3);
    }

    @Test
    public void testGetAllSubSets() {
        List<List<Integer>> sets = subsets.getAllSubsets(set);
        sets.forEach(System.out::println);
    }
}

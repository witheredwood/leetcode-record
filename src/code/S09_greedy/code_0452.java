package code.S09_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 452. 用最少数量的箭引爆气球
 *
 *
 */
public class code_0452 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(people));
        Iterator<int[]> it = list.iterator();
        int[] pre = null;
        while (it.hasNext()) {
            int[] cur = it.next();

        }

        return people;
    }
}

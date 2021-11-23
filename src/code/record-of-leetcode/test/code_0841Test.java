package test;

import leetcode_code.code_0841;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class code_0841Test {
    code_0841 one = new code_0841();

    @Test
    public void ExgOne() {
        int[][] arr = new int[][]{{1,3},{3,0,1},{2},{0}};
        boolean b = one.canVisitAllRooms(setList(arr));
        Assertions.assertEquals(false, b);
    }

    @Test
    public void ExgTwo() {
        int[][] arr = new int[][]{{1},{2},{3},{}};
        boolean b = one.canVisitAllRooms(setList(arr));
        Assertions.assertEquals(true, b);
    }

    public List<List<Integer>> setList(int[][] arr) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tmp = new LinkedList<Integer>();
           for (int t: arr[i])  tmp.add(t);
           res.add(tmp);
        }
        return res;
    }
}

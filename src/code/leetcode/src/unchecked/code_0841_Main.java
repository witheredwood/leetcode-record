package unchecked;

import java.util.LinkedList;
import java.util.List;

public class code_0841_Main {
    public static void main(String[] args) {
        code_0841 one = new code_0841();
        int[][] arr = new int[][]{{1},{2},{3},{}};
        System.out.println("org="+setList(arr));
        boolean b = one.canVisitAllRooms(setList(arr));
        System.out.println(b);
    }

    public static List<List<Integer>> setList(int[][] arr) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tmp = new LinkedList<Integer>();
            for (int t: arr[i])  tmp.add(t);
            res.add(tmp);
        }
        return res;
    }
}

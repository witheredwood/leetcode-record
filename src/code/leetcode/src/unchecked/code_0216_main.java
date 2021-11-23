package unchecked;

import java.util.LinkedList;
import java.util.List;

public class code_0216_main {
    public static void main(String[] args) {
        List<List<Integer>> res = new LinkedList<>();
//        int k = 3, n = 7;  // [[1,2,4]]
//        int k = 3, n = 9;  // [[1,2,6], [1,3,5], [2,3,4]]
        int k = 9, n = 45;  // [[1,2,3,4,5,6,7,8,9]]
        code_0216 one = new code_0216();
        res = one.combinationSum3(k, n);

        System.out.println("----------");
        for (List<Integer> tmp : res) {
            System.out.print("[");
            for (int i = 0; i < tmp.size() - 1; i++) {
                System.out.print(tmp.get(i) + ",");
            }
            System.out.println(tmp.get(tmp.size() - 1) + "]");
        }
    }
}

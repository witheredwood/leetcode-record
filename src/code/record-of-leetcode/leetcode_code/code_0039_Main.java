package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0039_Main {
    public static void main(String[] args) {
        code_0039 one = new code_0039();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new LinkedList<>();
        res = one.combinationSum(candidates, target);
        System.out.println("----------");
        for (List<Integer> tmp: res) {
            System.out.print("[");
            for (int i = 0; i < tmp.size() - 1; i++) {
                System.out.print(tmp.get(i) + ",");
            }
            System.out.println(tmp.get(tmp.size() - 1) + "]");
        }
    }
}

package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0078_Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new LinkedList<>();
        code_0078 one = new code_0078();
        res = one.subsets(nums);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
}

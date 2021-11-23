package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0046_Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3, 4};
        List<List<Integer>> res = new LinkedList<>();

        code_0046 one = new code_0046();
        res = one.permute(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
}

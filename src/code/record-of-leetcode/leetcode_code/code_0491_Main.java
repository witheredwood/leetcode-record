package leetcode_code;

import java.util.*;

public class code_0491_Main {
    public static void main(String[] args) {
        List<List<Integer>> res = new LinkedList<>();
        code_0491 one = new code_0491();
        // [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
        int[] nums = {4, 6, 7, 7};
        res = one.findSubsequences(nums);
        System.out.println("res="+res);

        // [4,4,3,2,1]
        // [[4,4]]
//        int[] nums2 = new int[]{4, 4, 3, 2, 1};
//        List<List<Integer>> res2 = one.findSubsequences(nums2);
//        System.out.println("res="+res2);

        // [1,3,5,7]
        // [[1,3],[1,3,5],[1,3,5,7],[1,3,7],[1,5],[1,5,7],[1,7],[3,5],[3,5,7],[3,7],[5,7]]
//        int[] nums3 = new int[]{1,3,5,7};
//        List<List<Integer>> res3 = one.findSubsequences(nums3);
//        System.out.println("res="+res3);

    }
}

package leetcode_code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class code_0473_Main {
    public static void main(String[] args) {
//        int[] nums = {1,1,2,2,2};  // true
//        int[] nums = {3,3,3,3,4};  // false
        int[] nums = {5,5,5,5,4,4,4,4,3,3,3,3};  // true
//        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};  // true
//        int[] nums = {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};


        code_0473 one = new code_0473();
        boolean res = one.makesquare(nums);
        System.out.println(res);
    }
}

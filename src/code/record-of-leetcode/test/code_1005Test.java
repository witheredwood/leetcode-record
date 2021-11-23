package test;


import leetcode_code.code_1005;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code_1005Test {
    code_1005 one = new code_1005();

    @Test
    public void test1() {
        int[] nums = {4,2,3};
        Assertions.assertEquals(5, one.largestSumAfterKNegations(nums,1));
    }

    @Test
    public void test2() {
        int[] nums = {3,-1,0,2};
        Assertions.assertEquals(6, one.largestSumAfterKNegations(nums,3));    }

    @Test
    public void test3() {
        int[] nums = {2,-3,-1,5,-4};
        Assertions.assertEquals(13, one.largestSumAfterKNegations(nums,2));    }

//    @Test
//    public void test4() {
//        int[] nums = {4,2,3};
//        Assertions.assertEquals(13, one.largestSumAfterKNegations(nums,1));    }

}

package test;

import leetcode_code.code143_0416;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class code143_0416Test {
    code143_0416 one = new code143_0416();

    @Test
    void test1() {
        int[] nums = {1,5,11,5};
        Assertions.assertEquals(true, one.canPartition(nums));
    }

    @Test
    void test2() {
        int[] nums = {1,2,3,5};
        Assertions.assertEquals(false, one.canPartition(nums));
    }

    @Test
    void test3() {
        int[] nums = {1};
        Assertions.assertEquals(false, one.canPartition(nums));
    }


}
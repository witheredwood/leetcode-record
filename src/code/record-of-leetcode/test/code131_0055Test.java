package test;

import leetcode_code.code131_0055;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code131_0055Test {
    code131_0055 one = new code131_0055();

    @Test
    void test1() {
        int[] nums = {2,3,1,1,4};
        Assertions.assertEquals(true, one.canJump(nums));
    }

    @Test
    void test2() {
        int[] nums = {3,2,1,0,4};
        Assertions.assertEquals(false, one.canJump(nums));
    }
}
package test;

import leetcode_code.code134_0045;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code134_0045Test {
    code134_0045 one = new code134_0045();

    @Test
    void test1() {
        int[] nums = {2,3,1,1,4};
        Assertions.assertEquals(2, one.jump(nums));
    }

    @Test
    void test2() {
        int[] nums = {2,3,0,1,4};
        Assertions.assertEquals(2, one.jump(nums));
    }
}
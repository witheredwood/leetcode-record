package test;

import leetcode_code.code133_0122;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code133_0122Test {
    code133_0122 one = new code133_0122();

    @Test
    void test1() {
        int[] arr = {7,1,5,3,6,4};
        Assertions.assertEquals(7, one.maxProfit(arr));
    }

    @Test
    void test2() {
        int[] arr = {1,2,3,4,5};
        Assertions.assertEquals(4, one.maxProfit(arr));
    }

    @Test
    void test3() {
        int[] arr = {7,6,4,3,1};
        Assertions.assertEquals(0, one.maxProfit(arr));
    }

}
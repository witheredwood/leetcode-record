package test;

import leetcode_code.code142_1049;
import org.junit.jupiter.api.*;

public class code142_1049Test {
    code142_1049 myone = new code142_1049();

    @Test
    void test1 () {
        int[] stones = {2,7,4,1,8,1};
       Assertions.assertEquals(1, myone.lastStoneWeightII(stones));
    }
    @Test
    public void test2 () {
        int[] stones = {2,7,4,1,8,1,9};
        Assertions.assertEquals(0, myone.lastStoneWeightII(stones));
    }
    @Test
    public void test3 () {
        int[] stones = {31,26,33,21,40};
        Assertions.assertEquals(5, myone.lastStoneWeightII(stones));
    }

    @Test
    public void test4 () {
        int[] stones = {1,2};
        Assertions.assertEquals(1, myone.lastStoneWeightII(stones));
    }
}

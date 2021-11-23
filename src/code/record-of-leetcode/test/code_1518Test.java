package test;

import leetcode_code.code_1518;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code_1518Test {
    code_1518 one = new code_1518();

    @Test
    public void test1() {
        Assertions.assertEquals(13, one.numWaterBottles(9,3));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(19, one.numWaterBottles(15, 4));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(6, one.numWaterBottles(5, 5));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(2, one.numWaterBottles(2, 3));
    }

}

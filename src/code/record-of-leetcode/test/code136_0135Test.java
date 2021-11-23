package test;

import leetcode_code.code136_0135;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code136_0135Test {
    code136_0135 one = new code136_0135();

    @Test
    void test1 () {
        int[] ratings = {1,0,2};
        Assertions.assertEquals(5, one.candy(ratings));
    }

    @Test
    void test2 () {
        int[] ratings = {1,2,2};
        Assertions.assertEquals(4, one.candy(ratings));
    }

    @Test
    void test3 () {
        int[] ratings = {1,3,2,2,1};
        Assertions.assertEquals(7, one.candy(ratings));
    }

    @Test
    void test4 () {
        int[] ratings = {1,5,4,3,2,1};
        Assertions.assertEquals(16, one.candy(ratings));
    }

}
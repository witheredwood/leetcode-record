package test;

import leetcode_code.code132_0056;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code132_0056Test {
    code132_0056 one = new code132_0056();

    @Test
    void test1() {
        int[][] arr = {{1,3},{8,10},{2,6},{15,18}};
        int[][] exp = {{1,6},{8,10},{15,18}};
        int[][] act = one.merge(arr);

        for (int i = 0; i < exp.length; i++) {
            Assertions.assertArrayEquals(exp[i], act[i]);
        }
    }

    @Test
    void test2() {
        int[][] arr = {{1,4},{4,5}};
        int[][] exp = {{1,5}};
        int[][] act = one.merge(arr);

        for (int i = 0; i < exp.length; i++) {
            Assertions.assertArrayEquals(exp[i], act[i]);
        }
    }

    @Test
    void test3() {
        int[][] arr = {{1,4},{2,3}};
        int[][] exp = {{1,4}};
        int[][] act = one.merge(arr);

        for (int i = 0; i < exp.length; i++) {
            Assertions.assertArrayEquals(exp[i], act[i]);
        }
    }

}
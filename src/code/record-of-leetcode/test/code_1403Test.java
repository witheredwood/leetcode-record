package test;

import leetcode_code.code_1403;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class code_1403Test {
    code_1403 one = new code_1403();

    @Test
    public void test1() {
        List<Integer> exp = new LinkedList<Integer>(){{
            add(10);
            add(9);
        }};
        int[] a = {4,3,10,9,8};
        Assertions.assertEquals(exp, one.minSubsequence(a));
    }

    @Test
    public void test2() {
        List<Integer> exp = new LinkedList<Integer>(){{
            add(7);
            add(7);
            add(6);
        }};
        int[] a = {4,4,7,6,7};
        Assertions.assertEquals(exp, one.minSubsequence(a));
    }

    @Test
    public void test3() {
        List<Integer> exp = new LinkedList<Integer>(){{
            add(6);
        }};
        int[] a = {6};
        Assertions.assertEquals(exp, one.minSubsequence(a));
    }

}

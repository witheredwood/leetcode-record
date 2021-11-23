package test;

import leetcode_code.code_0860;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code_0860Test {
    code_0860 one = new code_0860();

    @Test
    public void test1() {
        int[] bills = {5,5,5,10,20};
        Assertions.assertEquals(true, one.lemonadeChange(bills));
    }

    @Test
    public void test2() {
        int[] bills = {5,5,5,10};
        Assertions.assertEquals(true, one.lemonadeChange(bills));
    }

    @Test
    public void test3() {
        int[] bills = {10,10};
        Assertions.assertEquals(false, one.lemonadeChange(bills));
    }

    @Test
    public void test4() {
        int[] bills = {5,5,10,10,20};
        Assertions.assertEquals(false, one.lemonadeChange(bills));
    }

}

package test;

import leetcode_code.code140_0738;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class code140_0738Test {
    code140_0738 one = new code140_0738();

    @Test
    void test1() {
        Assertions.assertEquals(299, one.monotoneIncreasingDigits(332));
    }

    @Test
    void test2() {
        Assertions.assertEquals(334, one.monotoneIncreasingDigits(334));
    }

    @Test
    void test3() {
        Assertions.assertEquals(9, one.monotoneIncreasingDigits(10));
    }

    @Test
    void test4() {
        Assertions.assertEquals(1234, one.monotoneIncreasingDigits(1234));
    }

    @Test
    void test5() {
        Assertions.assertEquals(99, one.monotoneIncreasingDigits(100));
    }

}
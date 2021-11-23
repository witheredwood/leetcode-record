package test;

import leetcode_code.code141_0767;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class code141_0767Test {
    code141_0767 one = new code141_0767();

    @Test
    void test1() {
        String s = "aab";
        String r = "aba";
        Assertions.assertEquals(r ,one.reorganizeString(s));
    }

    @Test
    void test2() {
        String s = "aaab";
        String r = "";
        Assertions.assertEquals(r ,one.reorganizeString(s));
    }


    @Test
    void test3() {
        String s = "aaabb";
        String r = "ababa";
        Assertions.assertEquals(r ,one.reorganizeString(s));
    }

    @Test
    void test4() {
        String s = "a";
        String r = "a";
        Assertions.assertEquals(r ,one.reorganizeString(s));
    }

    @Test
    void test5() {
        String s = "aa";
        String r = "";
        Assertions.assertEquals(r ,one.reorganizeString(s));
    }

    @Test
    void test6() {
        String s = "vvvlo";
        String r = "vlvov";
        Assertions.assertEquals(r ,one.reorganizeString(s));
    }

    @Test
    void test7() {
        String s = "aabbcc";
        String r = "acabcb";
        Assertions.assertEquals(r ,one.reorganizeString(s));
    }
}
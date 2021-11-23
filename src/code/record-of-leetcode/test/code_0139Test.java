package test;

import leetcode_code.code_0139;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class code_0139Test {
    code_0139 one = new code_0139();

    @Test
    public void test1() {
        List<String> list = new LinkedList<>();
        String[] s = {"dd","ad","da","b"};
        for (String t: s) list.add(t);
        Assertions.assertEquals(true, one.wordBreak("ddadddbdddadd", list));
    }

    @Test
    public void test2() {
        List<String> list = new LinkedList<>();
        String[] s = {"cb","bc"};
        for (String t: s) list.add(t);
        Assertions.assertEquals(false, one.wordBreak("ccbb", list));
    }

    @Test
    public void test3() {
        List<String> list = new LinkedList<>();
        String[] s = {"leet","code"};
        for (String t: s) list.add(t);
        Assertions.assertEquals(true, one.wordBreak("leetcode", list));
    }

    @Test
    public void test4() {
        List<String> list = new LinkedList<>();
        String[] s = {"apple", "pen"};
        for (String t: s) list.add(t);
        Assertions.assertEquals(true, one.wordBreak("applepenapple", list));
    }

    @Test
    public void test5() {
        List<String> list = new LinkedList<>();
        String[] s = {"car","ca","rs"};
        for (String t: s) list.add(t);
        Assertions.assertEquals(true, one.wordBreak("cars", list));
    }

}
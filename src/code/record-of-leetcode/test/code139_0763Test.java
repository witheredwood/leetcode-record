package test;

import leetcode_code.code139_0763;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class code139_0763Test {
    code139_0763 one = new code139_0763();

    @Test
    void test1() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = one.partitionLabels(s);
        List<Integer> exp = new LinkedList<Integer>(){{
           add(9);  add(7); add(8);
        }};
        Assertions.assertEquals(exp, res);
    }

    @Test
    void test2() {
        String s = "a";
        List<Integer> res = one.partitionLabels(s);
        List<Integer> exp = new LinkedList<Integer>(){{
            add(1);
        }};
        Assertions.assertEquals(exp, res);
    }



}
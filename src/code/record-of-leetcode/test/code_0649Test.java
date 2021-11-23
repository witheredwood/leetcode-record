package test;

import leetcode_code.code_0649;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code_0649Test {
    code_0649 one = new code_0649();

    @Test
    void test1() {
        Assertions.assertEquals("Radiant", one.predictPartyVictory("RD"));
    }

    @Test
    void test2() {
        Assertions.assertEquals("Dire", one.predictPartyVictory("RDD"));
    }

    @Test
    void test3() {
        Assertions.assertEquals("Dire", one.predictPartyVictory("DDRRR"));
    }

    @Test
    void test4() {
        Assertions.assertEquals("Dire", one.predictPartyVictory("D"));
    }

    @Test
    void test5() {
        Assertions.assertEquals("Radiant", one.predictPartyVictory("DDRRRR"));
    }

    @Test
    void test6() {
        Assertions.assertEquals("Dire", one.predictPartyVictory("DRRD"));
    }

}
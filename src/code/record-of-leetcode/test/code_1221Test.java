package test;

import leetcode_code.code_1221;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class code_1221Test {
    code_1221 one = new code_1221();

    @Test
    public void test1() {
        Assertions.assertEquals(4, one.balancedStringSplit("RLRRLLRLRL"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(3, one.balancedStringSplit("RLLLLRRRLR"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(1, one.balancedStringSplit("LLLLRRRR"));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(2, one.balancedStringSplit("RLRRRLLRLL"));
    }

}

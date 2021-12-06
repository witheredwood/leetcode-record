package code.S06_stack_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 */
class code_0316Test extends code_0316 {
    String s1 = "bcabc";
    String expected1 = "abc";

    String s2 = "cbacdcbc";
    String expected2 = "acdb";

    String s3 = "abacb";
    String expected3 = "abc";

    @Test
    void testRemoveDuplicateLetters() {
        Assertions.assertEquals(expected1, removeDuplicateLetters(s1));
        System.out.println("---------------------------------------");
        Assertions.assertEquals(expected2, removeDuplicateLetters(s2));
        System.out.println("---------------------------------------");
        Assertions.assertEquals(expected3, removeDuplicateLetters(s3));
    }
}

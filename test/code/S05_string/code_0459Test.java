package code.S05_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
class code_0459Test extends code_0459 {
    String s1 = "abab";  // next数组
    boolean expected1 = true;

    String s2 = "aba";
    boolean expected2 = false;

    String s3 = "abcabcabcabc";
    boolean expected3 = true;

    String s4 = "abaababaab";
    boolean expected4 = true;

    @Test
    void testRepeatedSubstringPattern() {
        Assertions.assertEquals(expected1, repeatedSubstringPattern(s1));
        Assertions.assertEquals(expected2, repeatedSubstringPattern(s2));
        Assertions.assertEquals(expected3, repeatedSubstringPattern(s3));
        Assertions.assertEquals(expected4, repeatedSubstringPattern(s4));
    }
}

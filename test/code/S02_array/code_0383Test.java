package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
class code_0383Test extends code_0383 {
    String ransomNote1 = "a", magazine1 = "b";
    boolean expected1 = false;

    String ransomNote2 = "aa", magazine2 = "ab";
    boolean expected2 = false;

    String ransomNote3 = "aa", magazine3 = "acab";
    boolean expected3 = true;

    @Test
    void testCanConstruct() {
        Assertions.assertEquals(expected1, canConstruct(ransomNote1, magazine1));
        System.out.println("-------------------------------------");
        Assertions.assertEquals(expected2, canConstruct(ransomNote2, magazine2));
        System.out.println("-------------------------------------");
        Assertions.assertEquals(expected3, canConstruct(ransomNote3, magazine3));
    }

    @Test
    void testCanConstruct2() {
        Assertions.assertEquals(expected1, canConstruct2(ransomNote1, magazine1));
        System.out.println("-------------------------------------");
        Assertions.assertEquals(expected2, canConstruct2(ransomNote2, magazine2));
        System.out.println("-------------------------------------");
        Assertions.assertEquals(expected3, canConstruct2(ransomNote3, magazine3));
    }

    @Test
    void testCanConstruct3() {
        Assertions.assertEquals(expected1, canConstruct3(ransomNote1, magazine1));
        System.out.println("-------------------------------------");
        Assertions.assertEquals(expected2, canConstruct3(ransomNote2, magazine2));
        System.out.println("-------------------------------------");
        Assertions.assertEquals(expected3, canConstruct3(ransomNote3, magazine3));

    }
}

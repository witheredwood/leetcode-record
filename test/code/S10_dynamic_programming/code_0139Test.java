package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
class code_0139Test extends code_0139 {
    String s1 = "leetcode";
    String[] dict1 = {"leet", "code"};
    List<String> wordDict1 = Arrays.asList(dict1);
    boolean expected1 = true;

    String s2 = "applepenapple";
    String[] dict2 = {"apple", "pen"};
    List<String> wordDict2 = Arrays.asList(dict2);
    boolean expected2 = true;

    String s3 = "catsandog";
    String[] dict3 = {"cats", "dog", "sand", "and", "cat"};
    List<String> wordDict3 = Arrays.asList(dict3);
    boolean expected3 = false;

    @Test
    void testWordBreak() {
        Assertions.assertEquals(expected1, wordBreak(s1, wordDict1));
        System.out.println("-------------------------");
        Assertions.assertEquals(expected2, wordBreak(s2, wordDict2));
        System.out.println("-------------------------");
        Assertions.assertEquals(expected3, wordBreak(s3, wordDict3));
    }
}

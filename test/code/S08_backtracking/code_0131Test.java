package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
class code_0131Test extends code_0131 {
    String s1 = "aab";
    String[][] expected1 = {{"a", "a", "b"}, {"aa", "b"}};

    String s2 = "a";
    String[][] expected2 = {{"a"}};

    @Test
    void testPartition() {
        System.out.println(partition("abc").toString());
        System.out.println("--------------------");
        System.out.println(partition(s1).toString());
        System.out.println("--------------------");
        System.out.println(partition(s2).toString());
    }
}

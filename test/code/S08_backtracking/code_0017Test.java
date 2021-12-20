package code.S08_backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
class code_0017Test extends code_0017 {
    String digits1 = "23";
    String[] expected1 = {"ad","ae","af","bd","be","bf","cd","ce","cf"};

    String digits2 = "";
    String[] expected2 = {};

    String digits3 = "2";
    String[] expected3 = {"a","b","c"};

    @Test
    void testLetterCombinations() {
        Assertions.assertArrayEquals(expected1, letterCombinations(digits1).toArray());
        System.out.println("------------------------------");
        Assertions.assertArrayEquals(expected2, letterCombinations(digits2).toArray());
        System.out.println("------------------------------");
        Assertions.assertArrayEquals(expected3, letterCombinations(digits3).toArray());
    }
}

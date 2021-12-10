package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
class code_0343Test extends code_0343 {
    int n1 = 2, expected1 = 1;
    int n2 = 10, expected2 = 36;

    @Test
    void testIntegerBreak() {
//        Assertions.assertEquals(expected1, integerBreak(n1));
        Assertions.assertEquals(expected2, integerBreak(n2));
    }
}

package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */
class code_0279Test extends code_0279 {
    int n1 = 12, expected1 = 3;
    int n2 = 13, expected2 = 2;

    @Test
    void testNumSquares() {
        Assertions.assertEquals(expected1, numSquares(n1));
        System.out.println("----------------------");
        Assertions.assertEquals(expected2, numSquares(n2));
    }
}

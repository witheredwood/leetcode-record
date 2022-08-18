package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 */
class code_0332Test extends code_0322 {
    int[] coins1 = {1, 2, 5};
    int amount1 = 11, expected1 = 3;

    int[] coins2 = {2};
    int amount2 = 3, expected2 = -1;

    int[] coins3 = {1};
    int amount3 = 0, expected3 = 0;

    int[] coins4 = {1};
    int amount4 = 1, expected4 = 1;

    int[] coins5 = {1};
    int amount5 = 2, expected5 = 2;

    int[] coins6 = {186, 419, 83, 408};
    int amount6 = 6249, expected6 = 20;

    @Test
    void testCoinChange() {
        Assertions.assertEquals(expected1, coinChange(coins1, amount1));
        System.out.println("------------------------");
        Assertions.assertEquals(expected2, coinChange(coins2, amount2));
        System.out.println("------------------------");
        Assertions.assertEquals(expected3, coinChange(coins3, amount3));
        System.out.println("------------------------");
        Assertions.assertEquals(expected4, coinChange(coins4, amount4));
        System.out.println("------------------------");
        Assertions.assertEquals(expected5, coinChange(coins5, amount5));
        System.out.println("------------------------");
        Assertions.assertEquals(expected6, coinChange(coins6, amount6));
    }
}

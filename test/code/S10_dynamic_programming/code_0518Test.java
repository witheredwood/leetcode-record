package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * 输入：amount = 10, coins = [10]
 * 输出：1 
 */
class code_0518Test extends code_0518 {
    int amount1 = 5;
    int[] coins1 = {1, 2, 5};
    int expected1 = 4;

    int amount2 = 3;
    int[] coins2 = {2};
    int expected2 = 0;

    int amount3 = 10;
    int[] coins3 = {10};
    int expected3 = 1;

    @Test
    void testChange() {
        Assertions.assertEquals(expected1, change(amount1, coins1));
        System.out.println("--------------------------");
        Assertions.assertEquals(expected2, change(amount2, coins2));
        System.out.println("--------------------------");
        Assertions.assertEquals(expected3, change(amount3, coins3));
    }
}

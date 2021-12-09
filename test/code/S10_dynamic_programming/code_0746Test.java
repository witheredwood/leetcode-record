package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 */
class code_0746Test extends code_0746 {
    int[] cost1 = {10, 15, 20};
    int expected1 = 15;

    int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    int expected2 = 6;


    @Test
    void testMinCostClimbingStairs() {
        Assertions.assertEquals(expected1, minCostClimbingStairs(cost1));
        Assertions.assertEquals(expected2, minCostClimbingStairs(cost2));
    }
}

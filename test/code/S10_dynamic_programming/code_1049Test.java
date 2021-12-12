package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 * 输入：stones = [1,2]
 * 输出：1
 */
class code_1049Test extends code_1049 {
    int[] stones1 = {2, 7, 4, 1, 8, 1};
    int expected1 = 1;

    int[] stones2 = {31, 26, 33, 21, 40};
    int expected2 = 5;

    int[] stones3 = {1, 2};
    int expected3 = 1;

    @Test
    void testLastStoneWeightII() {
        Assertions.assertEquals(expected1, lastStoneWeightII(stones1));
        Assertions.assertEquals(expected2, lastStoneWeightII(stones2));
        Assertions.assertEquals(expected3, lastStoneWeightII(stones3));
    }

    @Test
    void testLastStoneWeightII2() {
        Assertions.assertEquals(expected1, lastStoneWeightII2(stones1));
        Assertions.assertEquals(expected2, lastStoneWeightII2(stones2));
        Assertions.assertEquals(expected3, lastStoneWeightII2(stones3));
    }
}

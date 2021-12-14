package code.S10_dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 * <p>
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。 
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
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
 * <p>
 * 提示：
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0518 {
    /**
     * 动态规划：完全背包
     * 使用二维数组存储，dp[j]: 总金额为 j 时，有多少种组合方案
     * 递推公式 / 状态转移方程，dp[j] = dp[j] + dp[j-coins[i]]  不放+放 的方案数
     * 递推 dp ，以 5, coins = [1, 2, 5] 为例
     *    0 1 2 3 4 5
     * 1 [1,1,1,1,1,1]
     * 2 [1,1,2,2,3,3]
     * 5 [1,1,2,2,3,4]
     * @param amount 总金额
     * @param coins 硬币面值数组
     * @return 总金额可以由现有的面值数组组成，有多少种方案
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int one: coins) {
            for (int i = one; i <= amount; i++) {
                dp[i] += dp[i - one];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}

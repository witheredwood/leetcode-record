package code.S10_dynamic_programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * 322. 零钱兑换
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
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
 *  
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0322 {
    /**
     * 动态规划：完全背包
     * 使用一维数组存储，dp[j]: 总金额 j 由硬币数组组成的最少的硬币数。
     * 以 coins = [1, 2, 5], amount = 11 为例
     * dp[11]，由 min {dp[11-5], dp[11-2], dp[11-1]}+1 推导而来
     * 递推公式 / 状态转移方程，dp[j] += dp[j-nums[i]]
     * 初始化，dp[0] = 0
     * 推导 dp 数组
     * 0 1 2 3 4 5 6 7 8 9 10 11
     * 1 0 1 2 2 3 4 2 3 3 4 4 5
     * 2 0 1 1 2 2 3 2 2 3 3 4 4
     * 5 0 1 1 2 2 1 2 2 3 3 2 3
     *
     * @param coins  不同金额的硬币数组
     * @param amount 总金额
     * @return 由硬币组成的总金额有多少种
     */
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        // 用整数的无穷大数初始化数组所有数
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;   // 初始化
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * 提示：
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 */
public class code_0746 {
    /**
     * 递归
     * 到达顶层的方法有两种：一种是到达 n-1 层，花费 n-1 层的花费值后到达顶层
     * 一种是到达 n-2 层，花费 n-2 层的花费值后到达顶层，比较两种方法中花费值最小的就是最低花费
     * 递推公式 c[n] = min{c[n-1] + cost[n-1], c[n-2] + cost[n-2]}
     *
     * @param cost 花费值数组
     * @return 到达顶层的最低花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 1) return cost[0];
        if (len == 2) return Math.min(cost[0], cost[1]);

        return 0;
    }

    /**
     * 动态规划
     * 到达顶层的方法有两种：一种是到达 n-1 层，花费 n-1 层的花费值后到达顶层
     * 一种是到达 n-2 层，花费 n-2 层的花费值后到达顶层，比较两种方法中花费值最小的就是最低花费
     * 对于 cost = [10, 15, 20]，台阶数是4，也就是要从第 0/1 个台阶到达第 4 个台阶
     * 使用一维数组存储 dp[i]：到达第i个台阶的最低花费
     * 递推公式 dp[n] = min{dp[n-1] + cost[n-1], dp[n-2] + cost[n-2]}
     * 初始化。由 n-1>=0 => n>=1，所以需要给出 dp[0] 和 dp[1]
     * 推导 dp 数组。对于 cost = [10, 15, 20] ，dp(4): 0 0 10 15
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *
     * @param cost 花费值数组
     * @return 到达顶层的最低花费
     */
    public int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        if (len <= 1) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}

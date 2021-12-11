package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0416 {
    /**
     * 动态规划：0-1背包问题
     * 状态转移方程 dp[i][j]: 在 0-i 个数中，和不超过 j 的最大总和
     *
     * @param nums 非空数组
     * @return 是否可以分割成两个子集，并且它们的总和相等
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;  // 数组总和
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        System.out.println("sum = " + sum);
        if (sum % 2 == 1) return false;  // 如果数组总和为奇数，则不可能分成两个总和相等的子集
        int bisum = sum / 2;  // 数组总和的一半
        int[][] dp = new int[len][bisum + 1];
        // 初始化第一行
        for (int i = 0; i <= bisum; i++) {
            if (nums[0] > bisum) return false;
            if (nums[0] == bisum) return true;
            if (nums[0] <= i) dp[0][i] = nums[0];
        }
        // 遍历
        for (int i = 1; i < len; i++) {
            if (nums[i] > bisum) return false;
            if (nums[i] == bisum) return true;
            for (int j = 0; j <= bisum; j++) {
                if (nums[i] <= j) dp[i][j] = Math.max(dp[i - 1][j], nums[i] + dp[i - 1][j - nums[i]]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[len - 1][bisum] == bisum;
    }
}

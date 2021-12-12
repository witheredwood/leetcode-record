package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 494. 目标和
 * <p>
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0494 {
    /**
     * 动态规划：0-1 背包
     * 数组中的数组成后的总和是 target，也就是正数与负数（绝对值）的差是target
     * 这样，就可以把数组中的数分成两类，一类是正数，一类是负数，求其差
     * 使用二维数组存储，dp[i][j]：使用 下标为[0, i]的nums[i]能够凑满 j（包括j）这么大容量的包，有dp[i][j]种方法
     *
     * @param nums   正数数组
     * @param target 所有数之和
     * @return 所有数之和为 target 的组合有几种方法
     */
    public int findTargetSumWays(int[] nums, int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int tmp : nums) {
            sum += tmp;
        }
        if (target > sum) return 0;
        if ((sum + target) % 2 == 1) return 0;
        int posSum = (sum + target) >> 1;  // 正数集合的总和
        int len = nums.length;
        int[][] dp = new int[len][posSum + 1];
        // 初始化
        dp[0][0] = 1;
        for (int i = posSum; i >= nums[0] ; i--) {
            dp[0][i] += dp[0][i - nums[0]];
        }
        // 遍历求解
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= posSum; j++) {
                if (j < nums[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[len - 1][posSum];
    }

    /**
     * 动态规划：0-1 背包
     * 数组中的数组成后的总和是 target，也就是正数与负数（绝对值）的差是target
     * 这样，就可以把数组中的数分成两类，一类是正数，一类是负数，求其差
     * 使用一维数组存储，dp[j]：装满容量为 j的包，有dp[j]种方法
     *
     * @param nums   正数数组
     * @param target 所有数之和
     * @return 所有数之和为 target 的组合有几种方法
     */
    public int findTargetSumWays2(int[] nums, int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int tmp : nums) {
            sum += tmp;
        }
        if (target > sum) return 0;
        if ((sum + target) % 2 == 1) return 0;
        int posSum = (sum + target) >> 1;  // 正数集合的总和
        int[] dp = new int[posSum + 1];
        // 初始化
        dp[0] = 1;
        // 遍历求解
        for (int i = 0; i < nums.length; i++) {
            for (int j = posSum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[posSum];
    }
}

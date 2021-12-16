package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ
 * <p>
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。 
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0377 {
    /**
     * 动态规划：完全背包
     * 使用一维数组存储，dp[j]: 凑成目标整数 i 的排列个数
     * dp[j] 可以由 dp[j-nums[i]] 推导出来
     *
     * @param nums   整数数组
     * @param target 总和
     * @return 由整数数组组成总和的方案有多少种
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 先遍历背包，后遍历物品
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}

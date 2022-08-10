package code.S10_dynamic_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    int count = 0;

    /**
     * 以空间换时间。
     * 上一个方法中，依次遍历，并判断在不在 nums 中会浪费时间。
     * 直接使用 nums 中存在的值计算，会减少时间
     * time: O(mn);     space: O(m)
     * m 是 target 的值，n 是 nums 的长度
     *
     * @param nums   整数数组
     * @param target 总和
     * @return 由整数数组组成总和的方案有多少种
     */
    public int combinationSum433(int[] nums, int target) {
        Arrays.sort(nums);
        int[] count = new int[target + 1];
        // 初始化
        count[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) count[nums[i]] = 1;
        }
        // 求个数
        for (int val = nums[0]; val <= target; val++) {
            int cur = 0;
            for (int i = 0; i < nums.length && nums[i] <= val; i++) {
                cur += count[val - nums[i]];
            }
            count[val] = cur;
        }
        return count[target];
    }

    /**
     * 以空间换时间。
     * 回溯的时间复杂度较大，只能以空间换时间了
     *
     * @param nums   整数数组
     * @param target 总和
     * @return 由整数数组组成总和的方案有多少种
     */
    public int combinationSum432(int[] nums, int target) {
        Arrays.sort(nums);
        int[] count = new int[target + 1];
        // 初始化
        count[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) count[nums[i]] = 1;
        }
        // 求个数
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int val = nums[0]; val <= target; val++) {
            int cur = 0;
            for (int j = val, k = 0; j > 0; j--, k++) {
                // k 在 nums 中，才能用 j + k 组成 i
                if (k == 0 || list.contains(k)) cur += count[j];
            }
            count[val] = cur;
        }
        return count[target];
    }

    /**
     * 回溯，超出时间限制。
     * 怎么说的，如果不限制递归的深度，回溯比较容易消耗更多的时间（自己猜的）
     *
     * @param nums   整数数组
     * @param target 总和
     * @return 由整数数组组成总和的方案有多少种
     */
    public int combinationSum431(int[] nums, int target) {
        backtracking(nums, target, 0);
        return count;
    }

    private void backtracking(int[] nums, int target, int sum) {
        if (sum > target) return;
        if (sum == target) {
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            backtracking(nums, target, sum + nums[i]);
        }
    }

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

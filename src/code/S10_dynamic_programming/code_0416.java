package code.S10_dynamic_programming;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
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
     * @param nums 非空数组
     * @return 是否可以分割成两个子集，并且它们的总和相等
     */
    public boolean canPartition33(int[] nums) {
        // 求总和。为奇数者，不能；为偶数者，有可能
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int halfSum = sum / 2;      // 每个子集的总和
        Arrays.sort(nums);      // 升序排列
        int[] array = new int[halfSum + 1];
        // 初始化
        for (int i = nums[0]; i <= halfSum; i++) {
            array[i] = nums[0];
        }
        // 求和的最大值
        for (int i = 1; i < nums.length; i++) {
            for (int j = halfSum; j > nums[i]; j--) {
                array[j] = Math.max(array[j], nums[i] + array[j - nums[i]]);
            }
        }
        return array[halfSum] == halfSum;
    }

    /**
     * 以 boolean 去判断是否能组成一个和为 sum 的数，无法区分当前能组成的数是由原有数组中的多个不同的数组成
     * 还是有重复的数，而数组中的数只能出现一次，不能重复利用。
     * boolean[][] isComposed = new boolean[nums.length][halfSum + 1];
     *
     * @param nums 非空数组
     * @return 是否可以分割成两个子集，并且它们的总和相等
     */
    public boolean canPartition32(int[] nums) {
        // 求总和。为奇数者，不能；为偶数者，有可能
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int halfSum = sum / 2;      // 每个子集的总和
        Arrays.sort(nums);      // 升序排列
        int[][] array = new int[nums.length][halfSum + 1];
        // 初始化
        for (int i = nums[0]; i <= halfSum; i++) {
            array[0][i] = nums[0];
        }
        // 求和的最大值
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= halfSum; j++) {
                if (j < nums[i]) array[i][j] = array[i - 1][j];
                else array[i][j] = Math.max(array[i - 1][j], nums[i] + array[i - 1][j - nums[i]]);
            }
        }
        return array[nums.length - 1][halfSum] == halfSum;
    }

//    public boolean canPartition31(int[] nums) {
//        if (nums.length == 1) return false;
//        // 求总和。为奇数者，不能；为偶数者，有可能
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum % 2 == 1) return false;
//        int halfSum = sum / 2;
//        // 判断数组是否能有几个数正好组成 halfSum
//        Arrays.sort(nums);
//        boolean[][] isComposed = new boolean[nums.length][halfSum + 1];
//        // 初始化
//        if (nums[0] <= halfSum) isComposed[0][nums[0]] = true;
//        for (int i = 0; i < nums.length; i++) {
//            isComposed[i][0] = true;
//        }
//        // 求其余值
//        for (int i = 0; i < nums.length; i++) {      // 依次在第1个子集中选择是否放入该整数
//            for (int j = 1; j <= halfSum; j++) {
//                if (j < nums[i]) isComposed[i][j] = isComposed[i - 1][j];
//                else isComposed[i][j] = isComposed[i - 1][j - nums[i]];     // 放入整数
//            }
//        }
//        System.out.println(Arrays.deepToString(isComposed));
//        return isComposed[nums.length - 1][halfSum];
//    }

    /**
     * 动态规划：0-1背包问题
     * 状态转移方程 dp[i][j]: 在 0-i 个数中，和不超过 j 的最大总和
     *
     * @param nums 非空数组
     * @return 是否可以分割成两个子集，并且它们的总和相等
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0; // 数组总和
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        System.out.println("sum = " + sum);
        if (sum % 2 == 1)
            return false; // 如果数组总和为奇数，则不可能分成两个总和相等的子集
        int bisum = sum / 2; // 数组总和的一半
        int[][] dp = new int[len][bisum + 1];
        // 初始化第一行
        for (int i = 0; i <= bisum; i++) {
            if (nums[0] > bisum)
                return false;
            if (nums[0] == bisum)
                return true;
            if (nums[0] <= i)
                dp[0][i] = nums[0];
        }
        // 遍历
        for (int i = 1; i < len; i++) {
            if (nums[i] > bisum)
                return false;
            if (nums[i] == bisum)
                return true;
            for (int j = 0; j <= bisum; j++) {
                if (nums[i] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i] + dp[i - 1][j - nums[i]]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[len - 1][bisum] == bisum;
    }
}

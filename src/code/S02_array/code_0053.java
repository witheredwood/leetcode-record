package code.S02_array;

import java.util.Arrays;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0053 {
    /**
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *
     * @param nums 给定的整数组
     * @return 连续子数组的最大和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length, max = nums[0];
        int[] sums = new int[len];
        sums[0] = nums[0];
        System.out.println("sums = " + Arrays.toString(sums) + " max = " + max);
        // 遍历数组
        for (int i = 1; i < len; i++) {
            sums[i] += nums[i] + (sums[i - 1] <= 0 ? 0 : sums[i - 1]);
            max = Math.max(max, sums[i]);
            System.out.println("sums = " + Arrays.toString(sums) + " max = " + max);
        }
        return max;
    }

    /**
     * 该解法是比较容易想到的
     * 时间复杂度是 O(n^2) ，空间复杂度是 O(1)。由于 O(n^2) 的时间复杂度太大，执行耗时过不去，
     * 所以要将时间复杂度优化到 O(nlogn) 以下
     *
     * @param nums 给定的整数组
     * @return 连续子数组的最大和
     */
    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) return 0;
        // 遍历数组
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmp = maxSubArrayFromStart(nums, i, nums.length);
            sum = Math.max(sum, tmp);
        }
        return sum;
    }

    public int maxSubArrayFromStart(int[] nums, int start, int len) {
        int sum = nums[start];  // 连续子数组的和，默认是数组中第一个数
        int unjoinedSum = 0; // 不加入到前面的总和中的数据的和
        int current;  // 当前遍历到的数
        for (int i = start + 1; i < nums.length; i++) {
            current = nums[i];
            // 要不要重新记录子数组
            int tmpSum = sum + unjoinedSum + current;

            if (current > Math.max(sum, tmpSum)) {  // 重新记录子数组
                sum = current;
                unjoinedSum = 0;
            } else {
                // 要不要加入到总和之中
                if (sum < tmpSum) { // 将当前数据和 unjoinedSum 中的数据加入到 sum 中
                    sum = tmpSum;
                    unjoinedSum = 0;
                } else {
                    unjoinedSum += current;
                }
            }
        }
        return sum;
    }
}

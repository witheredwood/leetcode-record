package code.S02_array;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0209 {
    /**
     * @param target 目标和，正整数
     * @param nums   正整数数组
     * @return 子数组之和不小于 target 的数组长度
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = 0, sum = 0;
        // 找到从0开始的子数组
        for (int i = 0; i < len && sum < target; i++) {
            sum += nums[i];
            res = i + 1;
        }
        System.out.println("res = " + res + " sum = " + sum);
        if (sum < target) return 0;  // 所有数加起来也小于 target
        sum -= nums[res - 1];
        for (int left = 1, right = res - 1; left <= right && right < len; left++, right++) {
            sum = sum - nums[left - 1] + nums[right];
            while (left <= right && sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * @param target 目标和，正整数
     * @param nums   正整数数组
     * @return 子数组之和不小于 target 的数组长度
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;  // 滑动窗口中的和
        int start = 0;  // 滑动窗口的起始位置
        int subLen = Integer.MAX_VALUE;  // 滑动窗口的长度
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                subLen = Math.min(subLen, i - start + 1);
                sum -= nums[start++];
            }
        }
        return subLen == Integer.MAX_VALUE ? 0: subLen;
    }
}

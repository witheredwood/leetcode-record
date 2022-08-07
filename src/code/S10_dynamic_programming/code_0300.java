package code.S10_dynamic_programming;

/**
 * 300. 最长递增子序列
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * 进阶：
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0300 {
    /**
     * time: O(n^2);        space: O(n)
     *
     * @param nums 整数数组
     * @return 最长严格递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        // 记录以位置 i 为结束的最大子序列长度
        int[] length = new int[nums.length];
        length[0] = 1;   // 第1个数的递增子序列长度为1
        int longestLength = 1;      // 最长递增子序列长度
        // 遍历，以当前位置 i 为起点，所有大于该位置 i 的数的最大递增子序列长度+1
        for (int i = 0; i < nums.length; i++) {
            // 若当前起点位置长度为0，则说明当前位置比之前的数均小，是新递增子序列的第1个数
            if (length[i] == 0) length[i] = 1;
            // 修改所有大于当前位置 i 的数的最大递增子序列长度
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    length[j] = Math.max(length[i] + 1, length[j]);
                    if (length[j] > longestLength) longestLength = length[j];     // 更新最长递增子序列长度
                }
            }
        }
        return longestLength;
    }
}

package code.S02_array;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0977 {
    /**
     * 排序。时间复杂度 O(nlogn + n)
     *
     * @param nums 给定的数组
     * @return 平方后排序的数组
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        // 平方
        for (int i = 0; i < len; i++) {
            nums[i] *= nums[i];
        }
        // 排序
        Arrays.sort(nums);
        System.out.println("sorted nums = " + Arrays.toString(nums));
        return nums;
    }

    /**
     * 空间换时间。时间复杂度 O(n)，空间复杂度 O(n)
     *
     * @param nums 给定的数组
     * @return 平方后排序的数组
     */
    public int[] sortedSquares2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] *= nums[i];
        }
        int left = 0, right = len - 1;
        int[] res = new int[len];
        int index = len - 1;
        // 从数组两端向中间，逐一比较，大者放res数组后面
        while (left <= right) res[index--] = nums[left] > nums[right] ? nums[left++] : nums[right--];
        System.out.println("sorted nums = " + Arrays.toString(res));
        return res;
    }
}

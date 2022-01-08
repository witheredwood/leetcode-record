package code.S09_greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1005.K次取反后最大化的数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -100 <= nums[i] <= 100
 * 1 <= k <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1005 {
    /**
     * 选择 k 个最小的数取反，如果数组中有0，则不用对大于0的正数取反
     * 时间复杂度 O(k*nlogn)，空间复杂度 O(1)
     *
     * @param nums 整数数组
     * @param k    正整数
     * @return 数组的最大和
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < k; i++) {
            Arrays.sort(nums);
            if (nums[0] == 0) break;
            sum -= 2 * nums[0];
            nums[0] = -nums[0];
            System.out.println("array = " + Arrays.toString(nums));
        }
        System.out.println("sum = " + sum);
        return sum;
    }

    /**
     * 选择 k 个最小的数取反，如果数组中有0，则不用对大于0的正数取反
     * 时间复杂度 O(nlogn)，空间复杂度 O(n)
     *
     * @param nums 整数数组
     * @param k    正整数
     * @return 数组的最大和
     */
    public int largestSumAfterKNegations2(int[] nums, int k) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Math.abs(b) - Math.abs(a);
            }
        });
        System.out.println("arr = " + Arrays.toString(arr));
        // 取反负数
        int count = 0;
        for (int i = 0; i < arr.length && count < k; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
                count++;
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
        // 取反正数中的最小数
        for (int i = count; i < k; i++) {
            arr[arr.length - 1] = -arr[arr.length - 1];
        }
        System.out.println("arr = " + Arrays.toString(arr));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("sum = " + sum);
        return sum;
    }
}

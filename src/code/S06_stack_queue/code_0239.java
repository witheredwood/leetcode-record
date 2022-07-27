package code.S06_stack_queue;

import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4<= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0239 {
    /**
     * 暴力方法
     * 超出时间限制
     * time: O(nk);      space: O(n)
     *
     * @param nums 数组
     * @param k    整数
     * @return 所有滑动窗口里的最大值。
     */
    public int[] maxSlidingWindow32(int[] nums, int k) {
        // 求解
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = 0; j < k && i + j < nums.length; j++) {
                max = Math.max(nums[i + j], max);
            }
            result[index++] = max;
        }
        return result;
    }

    /**
     * time: O(n klogk);      space: O(k)
     *
     * @param nums 数组
     * @param k    整数
     * @return 所有滑动窗口里的最大值。
     */
    public int[] maxSlidingWindow31(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        // 定义一个堆，并定义为大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return nums[b] - nums[a];
        });
        // 求解
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.offer(i);
        }
        int[] result = new int[nums.length - k + 1];
        result[index++] = nums[queue.peek()];
        for (int i = k; i < nums.length; i++) {
//            queue.remove(nums[j]);   // 移出一个元素 j = i - k。这一步大概费时间吧
            // 当前元素比队首值大，那么之后的最大值会是当前值，和队列中的值无关
            if (nums[i] > nums[queue.peek()]) queue.clear();
            // 从队首删除不在窗口内的值
            while (!queue.isEmpty() && i - queue.peek() >= k) queue.poll();
            queue.offer(i);
            result[index++] = nums[queue.peek()];
        }
        return result;
    }
}

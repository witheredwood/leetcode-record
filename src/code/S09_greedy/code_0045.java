package code.S09_greedy;

/**
 * 45.跳跃游戏II
 * <p>
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 示例 3:
 * 输入: nums = [7,0,9,6,9,6,1,7,9,0,2,9,0,3]
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0045 {
    /**
     * time: O(n);      space: O(1)
     *
     * @param nums 非负整数数组
     * @return 最少的跳跃次数到达数组的最后一个位置
     */
    public int jump31(int[] nums) {
        int count = 0;    // 最少次数次数
        int distance = 0;   // 最远距离
        int index = 0;      // 遍历的下标
        while (distance < nums.length - 1) {
            count++;    // 更新下一次的最远距离
            int curDistance = distance;
            for (; index <= curDistance; index++) {
                if (nums[index] + index > distance) {
                    distance = nums[index] + index;
                }
            }
        }
        return count;
    }

    /**
     * 双重循环
     * 时间复杂度 O(n*m)，空间复杂度 O(n)
     *
     * @param nums 非负整数数组
     * @return 最少的跳跃次数到达数组的最后一个位置
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                if (count[j] == 0) {
                    count[j] = count[i] + 1;
                }
                if (j >= len - 1) return count[len - 1];
            }
        }
        return count[len - 1];
    }
}

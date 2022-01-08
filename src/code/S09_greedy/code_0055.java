package code.S09_greedy;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0055 {
    /**
     * 遍历，将能到达的位置都标记出来
     * 时间复杂度 O(n*m)，空间复杂度 O(n)
     *
     * @param nums 非负整数数组 
     * @return 是否能到达最后一个位置
     */
    public boolean canJump(int[] nums) {
        boolean[] arrive = new boolean[nums.length];
        arrive[0] = true;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (arrive[i]) {  // 当前位置可到达
                for (int j = i + 1; j < len && j <= i + nums[i]; j++) {
                    arrive[j] = true;
                    if (arrive[len - 1]) return true;
                }
            }
        }
        return arrive[len - 1];
    }

    /**
     * 遍历，并记录当前位置所能到达的最远的位置，那么，在最远位置之前的位置都可到达
     * 时间复杂度 O(n)，空间复杂度 O(1)
     *
     * @param nums 非负整数数组 
     * @return 是否能到达最后一个位置
     */
    public boolean canJump2(int[] nums) {
        int far = 0;  // 到达的最远的位置
        for (int i = 0; i < nums.length && i <= far; i++) {
            far = Math.max(far, i + nums[i]);
        }
        return far >= nums.length - 1;
    }
}

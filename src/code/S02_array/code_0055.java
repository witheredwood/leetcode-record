package code.S02_array;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0055 {
  /**
   * 因为只需要判断是否能跳到最后一个位置，不需要知道怎么跳过去的，所以不需要记录跳的过程。
   * 不管怎么跳，只要能跳到的最远的距离能比最后一个位置远，那么就是能跳到的。
   * time: O(n);    space: O(1)
   *
   * @param nums 数组
   * @return 是否可以跳到最后一个位置
   */
  public boolean canJump(int[] nums) {
    int distance = nums[0];  // 能跳到的最长距离
    for (int i = 1; i <= distance && distance < nums.length - 1; i++) {
      distance = Math.max(i + nums[i], distance);
    }
    if (distance >= nums.length - 1) {
      return true;
    }
    return false;
  }
}

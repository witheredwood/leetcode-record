package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 486. 预测赢家
 * <p>
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），
 * 取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。
 * 当数组中没有剩余数字可取时，游戏结束。
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,2]
 * 输出：false
 * 解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 false 。
 * 示例 2：
 * 输入：nums = [1,5,233,7]
 * 输出：true
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。
 * <p>
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0486 {
    private int score = 0;  // 玩家1的分数是加数，玩家2的分数是减数，score 表示的是玩家1-玩家2的分数

    /**
     * @param nums 整型数组
     * @return 第一个玩家是不是赢家，第1个玩家的分数大于等于第2个玩家时赢
     */
    public boolean PredictTheWinner(int[] nums) {
        System.out.println("nums: " + Arrays.toString(nums));
        zeroSumGame(nums, 0, nums.length - 1, 0);
        System.out.println("score: " + score);
        return score >= 0;
    }

    /**
     * 零和博弈的递归实现
     *
     * @param nums  整型数组
     * @param left  数组的左边界
     * @param right 数组的右边界
     * @param index 玩家的序号，0为玩家1，1为玩家2
     */
//    public void zeroSumGame(int[] nums, int left, int right, int index, int curScore) {
    public void zeroSumGame(int[] nums, int left, int right, int index) {
        // 只有一个数时，只有1个选择
        if (left == right) {
            if (index == 0) score += nums[left];
            else score -= nums[left];
            return;
        }

        // 先手有2个选择时，会选择让后手陷入更差局面的方案
        int value1 = Math.max(nums[left + 1], nums[right]);  // 先手选择left的值时，后手能选择的最大值
        int value2 = Math.max(nums[left], nums[right - 1]);  // 先手选择right的值时，后手能选择的最大值
        // 先手选择让后手陷入更差局面的方案
        int selectValue = 0;
//        int firstSelectLeft = nums[left] - nums[right];   // 先手选择 left 比选择 right 多拿的分数
//        int secondSelectLeft = value1 - value2;  // 后手在先手选择 left 比选择 right 多拿的分数

        int firstScore = nums[left] - value1;   // 选择 left
        int secondScore = nums[right] - value2;   // 选择 right
        if (firstScore >= secondScore) {
            System.out.println("玩家" + index + " 选择了 " + left + " " + nums[left]);
            selectValue = nums[left];
            if (index == 0) score += selectValue;
            else score -= selectValue;
            zeroSumGame(nums, left + 1, right, (index + 1) % 2);
        } else {
            System.out.println("玩家" + index + " 选择了 " + right + " " + nums[right]);
            selectValue = nums[right];
            if (index == 0) score += selectValue;
            else score -= selectValue;
            zeroSumGame(nums, left, right - 1, (index + 1) % 2);
        }
//        System.out.println("left: " + left + " right: " + right + " value1: " + value1 + " value2: " + value2);
//        if (value1 < value2 || (value1 == value2 && nums[left] > nums[right])) {  // 先手选择 left 的值
//            System.out.println("玩家" + index + " 选择了 " + left + " " + nums[left]);
//            selectValue = nums[left];
//            if (index == 0) score += selectValue;
//            else score -= selectValue;
//            zeroSumGame(nums, left + 1, right, (index + 1) % 2);
//        } else {  // 先手选择 right 的值
//            System.out.println("玩家" + index + " 选择了 " + right + " " + nums[right]);
//            selectValue = nums[right];
//            if (index == 0) score += selectValue;
//            else score -= selectValue;
//            zeroSumGame(nums, left, right - 1, (index + 1) % 2);
//        }
    }
}

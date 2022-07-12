package code.S10_dynamic_programming;

import code.S07_tree.code_0127;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
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
 */
class code_0486Test extends code_0486 {

    @Test
    void predictTheWinner() {
        int[] nums = {1, 5, 2};
        boolean flag = PredictTheWinner(nums);
        Assertions.assertEquals(false, flag);
    }

    @Test
    void predictTheWinner2() {
        int[] nums = {1, 5, 233, 7};
        boolean flag = PredictTheWinner(nums);
        Assertions.assertEquals(true, flag);
    }

    @Test
    void predictTheWinner3() {
        int[] nums = {1000, 999, 999, 1000, 555, 400};
        boolean flag = PredictTheWinner(nums);
        Assertions.assertEquals(true, flag);
    }

    @Test
    void predictTheWinner4() {
        int[] nums = {3606449, 6, 5, 9, 452429, 7, 9580316, 9857582, 8514433, 9, 6, 6614512, 753594, 5474165, 4, 2697293, 8, 7, 1};
        boolean flag = PredictTheWinner(nums);
        Assertions.assertEquals(false, flag);
    }
}
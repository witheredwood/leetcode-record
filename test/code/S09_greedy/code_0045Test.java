package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
class code_0045Test extends code_0045 {
    int[] nums1 = {2, 3, 1, 1, 4};
    int expected1 = 2;

    int[] nums2 = {2,3,0,1,4};
    int expected2 = 2;

    @Test
    void testJump() {
        System.out.println(Arrays.toString(nums1));
        Assertions.assertEquals(2, jump(nums1));
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(nums2));
        Assertions.assertEquals(2, jump(nums2));
    }
}

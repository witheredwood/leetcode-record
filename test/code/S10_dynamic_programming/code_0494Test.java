package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 */
class code_0494Test extends code_0494 {
    int[] nums1 = {1, 1, 1, 1, 1};
    int target1 = 3;
    int expected1 = 5;

    int[] nums2 = {1};
    int target2 = 1;
    int expected2 = 1;

    int[] nums3 = {1, 0};
    int target3 = 1;
    int expected3 = 2;

    int[] nums4 = {0,0,0,0,0,0,0,0,1};
    int target4 = 1;
    int expected4 = 256;

    @Test
    void testFindTargetSumWays() {
        Assertions.assertEquals(expected1, findTargetSumWays(nums1, target1));
        System.out.println("----------------");
        Assertions.assertEquals(expected2, findTargetSumWays(nums2, target2));
        System.out.println("----------------");
        Assertions.assertEquals(expected3, findTargetSumWays(nums3, target3));
        System.out.println("----------------");
        Assertions.assertEquals(expected4, findTargetSumWays(nums4, target4));
    }

    @Test
    void testFindTargetSumWays2() {
        Assertions.assertEquals(expected1, findTargetSumWays2(nums1, target1));
        System.out.println("----------------");
        Assertions.assertEquals(expected2, findTargetSumWays2(nums2, target2));
        System.out.println("----------------");
        Assertions.assertEquals(expected3, findTargetSumWays2(nums3, target3));
        System.out.println("----------------");
        Assertions.assertEquals(expected4, findTargetSumWays2(nums4, target4));
    }
}

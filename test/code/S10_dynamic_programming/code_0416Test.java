package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
class code_0416Test extends code_0416 {
    int[] nums1 = {1, 5, 11, 5};
    boolean expected1 = true;

    int[] nums2 = {1, 2, 3, 5};
    boolean expected2 = false;

    int[] nums3 = {11, 5, 1, 5};
    boolean expected3 = true;

    @Test
    void testCanPartition() {
        Assertions.assertEquals(expected1, canPartition(nums1));
        Assertions.assertEquals(expected2, canPartition(nums2));
        Assertions.assertEquals(expected3, canPartition(nums3));
    }
}

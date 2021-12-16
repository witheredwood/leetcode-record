package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 */
class code_0377Test extends code_0377 {
    int[] nums1 = {1, 2, 3};
    int target1 = 4, expected1 = 7;

    int[] nums2 = {9};
    int target2 = 3, expected2 = 0;

    @Test
    void testCombinationSum4() {
        Assertions.assertEquals(expected1, combinationSum4(nums1, target1));
        System.out.println("-----------------");
        Assertions.assertEquals(expected2, combinationSum4(nums2, target2));
    }
}

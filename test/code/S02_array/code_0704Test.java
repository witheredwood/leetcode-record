package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
class code_0704Test extends code_0704 {
    int[] nums1 = {-1,0,3,5,9,12};
    int target1 = 9;
    int expected1 = 4;

    int[] nums2 = {-1,0,3,5,9,12};
    int target2 = 2;
    int expected2 = -1;
    @Test
    void testSearch() {
        Assertions.assertEquals(expected1,search(nums1, target1));
        Assertions.assertEquals(expected2,search(nums2, target2));

    }
}

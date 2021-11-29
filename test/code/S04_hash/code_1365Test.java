package code.S04_hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 */
class code_1365Test extends code_1365 {
    int[] nums1 = {8, 1, 2, 2, 3};
    int[] expected1 = {4, 0, 1, 1, 3};

    int[] nums2 = {6, 5, 4, 8};
    int[] expected2 = {2, 1, 0, 3};

    int[] nums3 = {7, 7, 7, 7};
    int[] expected3 = {0, 0, 0, 0};

    @Test
    void testSmallerNumbersThanCurrent() {
        Assertions.assertArrayEquals(expected1, smallerNumbersThanCurrent(nums1));
        System.out.println("------------------------------");
        Assertions.assertArrayEquals(expected2, smallerNumbersThanCurrent(nums2));
        System.out.println("------------------------------");
        Assertions.assertArrayEquals(expected3, smallerNumbersThanCurrent(nums3));
    }

    @Test
    void testSmallerNumbersThanCurrent2() {
        Assertions.assertArrayEquals(expected1, smallerNumbersThanCurrent2(nums1));
        System.out.println("------------------------------");
        Assertions.assertArrayEquals(expected2, smallerNumbersThanCurrent2(nums2));
        System.out.println("------------------------------");
        Assertions.assertArrayEquals(expected3, smallerNumbersThanCurrent2(nums3));
    }
}

package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
class code_0209Test extends code_0209 {
    int target1 = 7;
    //    int[] nums1 = {4, 3, 2, 3, 1, 2};
    int[] nums1 = {2, 3, 1, 2, 4, 3};
    int expected1 = 2;

    int target2 = 4;
    int[] nums2 = {1, 4, 4};
    int expected2 = 1;

    int target3 = 11;
    int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
    int expected3 = 0;

    int target4 = 11;
    int[] nums4 = {1, 2, 3, 4, 5};
    int expected4 = 3;

    @Test
    void testMinSubArrayLen1() {
        System.out.println("nums = " + Arrays.toString(nums1) + " target = " + target1);
        Assertions.assertEquals(expected1, minSubArrayLen(target1, nums1));
        Assertions.assertEquals(expected1, minSubArrayLen2(target1, nums1));
    }

    @Test
    void testMinSubArrayLen2() {
        System.out.println("nums = " + Arrays.toString(nums2) + " target = " + target2);
        Assertions.assertEquals(expected2, minSubArrayLen(target2, nums2));
        Assertions.assertEquals(expected2, minSubArrayLen2(target2, nums2));
    }

    @Test
    void testMinSubArrayLen3() {
        System.out.println("nums = " + Arrays.toString(nums3) + " target = " + target3);
        Assertions.assertEquals(expected3, minSubArrayLen(target3, nums3));
        Assertions.assertEquals(expected3, minSubArrayLen2(target3, nums3));
    }

    @Test
    void testMinSubArrayLen4() {
        System.out.println("nums = " + Arrays.toString(nums4) + " target = " + target4);
        Assertions.assertEquals(expected4, minSubArrayLen(target4, nums4));
        Assertions.assertEquals(expected4, minSubArrayLen2(target4, nums4));
    }
}

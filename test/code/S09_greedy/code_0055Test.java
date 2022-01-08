package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
class code_0055Test extends code_0055 {
    int[] nums1 = {2, 3, 1, 1, 4};
    boolean expected1 = true;

    int[] nums2 = {3, 2, 1, 0, 4};
    boolean expected2 = false;

    int[] nums3 = {0, 2, 3};
    boolean expected3 = false;

    int[] nums4 = {0};
    boolean expected4 = true;

    @Test
    void testCanJump() {
        Assertions.assertEquals(expected1, canJump(nums1));
        System.out.println(canJump(nums1));
        System.out.println("----------------------------");
        Assertions.assertEquals(expected2, canJump(nums2));
        System.out.println(canJump(nums2));
        System.out.println("----------------------------");
        Assertions.assertEquals(false, canJump(new int[]{0, 2, 3}));
        System.out.println(canJump(nums3));
        System.out.println("----------------------------");
        Assertions.assertEquals(true, canJump(new int[]{0}));
        System.out.println(canJump(nums4));
    }

    @Test
    void testCanJump2() {
        System.out.println(Arrays.toString(nums1));
        Assertions.assertEquals(expected1, canJump2(nums1));
        System.out.println(nums1 + " " + canJump(nums1));
        System.out.println("----------------------------");
        Assertions.assertEquals(expected2, canJump2(nums2));
        System.out.println(nums2 + " "  +canJump(nums2));
        System.out.println("----------------------------");
        Assertions.assertEquals(false, canJump2(new int[]{0, 2, 3}));
        System.out.println(nums3 + " "  + canJump(nums3));
        System.out.println("----------------------------");
        Assertions.assertEquals(true, canJump2(new int[]{0}));
        System.out.println(nums4 + " "  + canJump(nums4));
        System.out.println(new int[]{1, 2, 3} + " "  + canJump(new int[]{1, 2, 3}));
    }
}

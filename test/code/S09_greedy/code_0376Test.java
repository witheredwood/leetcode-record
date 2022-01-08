package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 示例 2：
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 示例 3：
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 */
class code_0376Test extends code_0376 {
    int[] nums1 = {1, 7, 4, 9, 2, 5};
    int expected1 = 6;

    int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
    int expected2 = 7;

    int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int expected3 = 2;

    @Test
    void testWiggleMaxLength() {
        System.out.println(Arrays.toString(nums1));
        Assertions.assertEquals(expected1, wiggleMaxLength(nums1));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(nums2));
        Assertions.assertEquals(expected2, wiggleMaxLength(nums2));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(nums3));
        Assertions.assertEquals(expected3, wiggleMaxLength(nums3));
        System.out.println("-----------------------------");
        Assertions.assertEquals(1, wiggleMaxLength(new int[]{2}));
        System.out.println("-----------------------------");
        Assertions.assertEquals(1, wiggleMaxLength(new int[]{0, 0}));
    }

    @Test
    void testWiggleMaxLength2() {
        System.out.println(Arrays.toString(nums1));
        Assertions.assertEquals(expected1, wiggleMaxLength2(nums1));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(nums2));
        Assertions.assertEquals(expected2, wiggleMaxLength2(nums2));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(nums3));
        Assertions.assertEquals(expected3, wiggleMaxLength2(nums3));
        System.out.println("-----------------------------");
        Assertions.assertEquals(1, wiggleMaxLength(new int[]{2}));
        System.out.println("-----------------------------");
        Assertions.assertEquals(1, wiggleMaxLength(new int[]{0, 0}));
    }
}

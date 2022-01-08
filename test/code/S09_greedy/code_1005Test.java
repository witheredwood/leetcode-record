package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 */
class code_1005Test extends code_1005 {
    int[] nums1 = {4, 2, 3};
    int k1 = 1;
    int expected1 = 5;

    int[] nums2 = {3, -1, 0, 2};
    int k2 = 3;
    int expected2 = 6;

    int[] nums3 = {2, -3, -1, 5, -4};
    int k3 = 2;
    int expected3 = 13;

    @Test
    void testLargestSumAfterKNegations() {
        Assertions.assertEquals(5, largestSumAfterKNegations(nums1, k1));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(6, largestSumAfterKNegations(nums2, k2));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(13, largestSumAfterKNegations(nums3, k3));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(3, largestSumAfterKNegations(new int[]{-3}, 1));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(32, largestSumAfterKNegations(new int[]{-2, 9, 9, 8, 4}, 5));
    }

    @Test
    void testLargestSumAfterKNegations2() {
        Assertions.assertEquals(5, largestSumAfterKNegations2(nums1, k1));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(6, largestSumAfterKNegations2(nums2, k2));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(13, largestSumAfterKNegations2(nums3, k3));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(3, largestSumAfterKNegations2(new int[]{-3}, 1));
        System.out.println("--------------------------------------------------");
        Assertions.assertEquals(32, largestSumAfterKNegations2(new int[]{-2, 9, 9, 8, 4}, 5));
    }
}

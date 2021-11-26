package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
class code_0977Test extends code_0977 {
    int[] nums1 = {-4, -1, 0, 3, 10};
    int[] expected1 = {0, 1, 9, 16, 100};

    int[] nums2 = {-7, -3, 2, 3, 11};
    int[] expected2 = {4, 9, 9, 49, 121};

    @Test
    void testSortedSquares1() {
        System.out.println("nums = " + Arrays.toString(nums1));
        Assertions.assertArrayEquals(expected1, sortedSquares(nums1));
    }

    @Test
    void testSortedSquares2() {
        System.out.println("nums = " + Arrays.toString(nums2));
        Assertions.assertArrayEquals(expected2, sortedSquares(nums2));
    }

    @Test
    void testSortedSquares11() {
        System.out.println("nums = " + Arrays.toString(nums1));
        Assertions.assertArrayEquals(expected1, sortedSquares2(nums1));
    }

    @Test
    void testSortedSquares22() {
        System.out.println("nums = " + Arrays.toString(nums2));
        Assertions.assertArrayEquals(expected2, sortedSquares2(nums2));
    }
}

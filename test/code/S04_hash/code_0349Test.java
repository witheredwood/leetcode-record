package code.S04_hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
class code_0349Test extends code_0349 {
    int[] nums11 = {1, 2, 2, 1}, nums21 = {2, 2};
    int[] expected1 = {2};

    int[] nums12 = {4, 9, 5}, nums22 = {9, 4, 9, 8, 4};
    int[] expected2 = {4, 9};

    @Test
    void testIntersection() {
        Assertions.assertArrayEquals(expected1, intersection(nums11, nums21));
        System.out.println("-----------------------------");
        Assertions.assertArrayEquals(expected2, intersection(nums12, nums22));
    }
}

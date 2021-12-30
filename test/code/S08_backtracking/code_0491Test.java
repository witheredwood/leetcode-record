package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 */
class code_0491Test extends code_0491 {
    int[] nums1 = {4, 6, 7, 7};
    int[][] expected1 = {{4, 6}, {4, 6, 7}, {4, 6, 7, 7}, {4, 7}, {4, 7, 7}, {6, 7}, {6, 7, 7}, {7, 7}};

    int[] nums2 = {4, 4, 3, 2, 1};
    int[][] expected2 = {{4, 4}};

    int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};

    @Test
    void testFindSubsequences() {
        System.out.println(findSubsequences(nums1).toString());
        System.out.println("----------------");
        System.out.println(findSubsequences(nums2).toString());
        System.out.println("----------------");
        System.out.println(findSubsequences(nums3).toString());
    }
}

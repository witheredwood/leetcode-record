package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
class code_0078Test extends code_0078 {
    int[] nums1 = {1, 2, 3};
    int[][] expected1 = {{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}};

    int[] nums2 = {0};
    int[][] expected2 = {{}, {0}};

    @Test
    void testSubsets() {
        System.out.println(subsets(nums1).toString());
        System.out.println(subsets(nums2).toString());
    }
}

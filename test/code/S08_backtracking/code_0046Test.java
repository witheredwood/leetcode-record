package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
class code_0046Test extends code_0046 {
    int[] nums1 = {1, 2, 3};
    int[][] expected1 = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

    int[] nums2 = {0, 1};
    int[][] expected2 = {{0, 1}, {1, 0}};

    int[] nums3 = {1};
    int[][] expected3 = {{1}};

    @Test
    void testPermute() {
        System.out.println(permute(nums1).toString());
        System.out.println(permute(nums2).toString());
        System.out.println(permute(nums3).toString());
    }
}

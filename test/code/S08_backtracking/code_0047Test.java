package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
class code_0047Test extends code_0047 {
    int[] nums1 = {1,1,2};
    int[][] expected1 = {{1, 1, 2}, {1, 2, 1}, {2, 1, 1}};

    int[] nums2 = {1,2,3};
    int[][] expected2 = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

    @Test
    void testPermuteUnique() {
        System.out.println(permuteUnique(nums1).toString());
        System.out.println("-------------------------------");
        System.out.println(permuteUnique(nums2).toString());
    }

    @Test
    void testPermuteUnique2() {
        System.out.println(permuteUnique2(nums1).toString());
        System.out.println("-------------------------------");
        System.out.println(permuteUnique2(nums2).toString());
    }
}

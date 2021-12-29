package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
class code_0090Test extends code_0090 {
    int[] nums1 = {1, 2, 2};
    int[][] expected1 = {{}, {1}, {2}, {1, 2, 2}, {2, 2}};

    int[] nums2 = {0};
    int[][] expected2 = {{}, {0}};

    @Test
    void testSubsetsWithDup() {
        System.out.println(subsetsWithDup(nums1).toString());
        System.out.println(subsetsWithDup(nums2).toString());
    }
}

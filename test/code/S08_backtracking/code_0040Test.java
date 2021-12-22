package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
class code_0040Test extends code_0040 {
    int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
    int target1 = 8;
    int[][] expected1 = {{1, 1, 6}, {1, 2, 5}, {1, 7}, {2, 6}};

    int[] candidates2 = {2, 5, 2, 1, 2};
    int target2 = 5;
    int[][] expected2 = {{1, 2, 2}, {5}};

    @Test
    void testCombinationSum2() {
        System.out.println(combinationSum2(candidates1, target1));
        System.out.println("--------------------");
        System.out.println(combinationSum2(candidates2, target2));
    }
}

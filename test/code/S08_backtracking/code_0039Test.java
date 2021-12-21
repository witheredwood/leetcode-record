package code.S08_backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 */
class code_0039Test extends code_0039 {
    int[] candidates1 = {2, 3, 6, 7};
    int target1 = 7;
    int[][] expected1 = {{2, 2, 3}, {7}};

    int[] candidates2 = {2, 3, 5};
    int target2 = 8;
    int[][] expected2 = {{2, 2, 2, 2}, {2, 3, 3}, {3, 5}};

    int[] candidates3 = {2};
    int target3 = 1;
    int[][] expected3 = {};

    int[] candidates4 = {1};
    int target4 = 1;
    int[][] expected4 = {{1}};

    int[] candidates5 = {1};
    int target5 = 2;
    int[][] expected5 = {{1, 1}};

    @Test
    void testCombinationSum() {
        System.out.println(combinationSum(candidates1, target1));
        System.out.println("--------------------");
        System.out.println(combinationSum(candidates2, target2));
        System.out.println("--------------------");
        System.out.println(combinationSum(candidates3, target3));
        System.out.println("--------------------");
        System.out.println(combinationSum(candidates4, target4));
        System.out.println("--------------------");
        System.out.println(combinationSum(candidates5, target5));
    }
}

package code.S08_backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
class code_0077Test extends code_0077 {
    int n1 = 4, k1 = 2;
    int[][] expected1 = {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};

    int n2 = 1, k2 = 1;
    int[][] expected2 = {{1}};

    @Test
    void testCombine() {
        System.out.println(combine(n1, k1).toString());
        System.out.println("-----------------");
        System.out.println(combine(n2, k2).toString());
    }

    @Test
    void testCombine2() {
        System.out.println(combine2(n1, k1).toString());
        System.out.println("-----------------");
        System.out.println(combine2(n2, k2).toString());
    }
}

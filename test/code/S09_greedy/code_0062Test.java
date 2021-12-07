package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 */
class code_0062Test extends code_0062 {
    int m1 = 3, n1 = 7, expected1 = 28;
    int m2 = 3, n2 = 2, expected2 = 3;
    int m3 = 7, n3 = 3, expected3 = 28;
    int m4 = 3, n4 = 3, expected4 = 6;

    @Test
    void testUniquePaths() {
        Assertions.assertEquals(expected1, uniquePaths(m1, n1));
        Assertions.assertEquals(expected2, uniquePaths(m2, n2));
        Assertions.assertEquals(expected3, uniquePaths(m3, n3));
        Assertions.assertEquals(expected4, uniquePaths(m4, n4));
    }

    @Test
    void testUniquePaths2() {
        Assertions.assertEquals(expected1, uniquePaths2(m1, n1));
        Assertions.assertEquals(expected2, uniquePaths2(m2, n2));
        Assertions.assertEquals(expected3, uniquePaths2(m3, n3));
        Assertions.assertEquals(expected4, uniquePaths2(m4, n4));
    }

    @Test
    void testUniquePaths3() {
        Assertions.assertEquals(expected1, uniquePaths3(m1, n1));
        Assertions.assertEquals(expected2, uniquePaths3(m2, n2));
        Assertions.assertEquals(expected3, uniquePaths3(m3, n3));
        Assertions.assertEquals(expected4, uniquePaths3(m4, n4));
    }
}

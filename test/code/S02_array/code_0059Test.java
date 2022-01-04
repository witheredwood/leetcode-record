package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 */
class code_0059Test extends code_0059 {
    int n1 = 3;
    int[][] expected1 = {{1,2,3},{8,9,4},{7,6,5}};

    int n2 = 1;
    int[][] expected2 = {{1}};

    @Test
    void testGenerateMatrix() {
        Assertions.assertArrayEquals(expected2, generateMatrix(n2));
        System.out.println("------------------------");
        Assertions.assertArrayEquals(expected1, generateMatrix(n1));
    }
}

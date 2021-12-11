package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 */
class code_0096Test extends code_0096 {
    int n1 = 1, expected1 = 1;
    int n2 = 2, expected2 = 2;
    int n3 = 3, expected3 = 5;
    int n4 = 4, expected4 = 14;
    int n5 = 5, expected5 = 42;
    int n6 = 6, expected6 = 132;

    @Test
    void testNumTrees() {
        Assertions.assertEquals(expected1, numTrees(n1));
        Assertions.assertEquals(expected2, numTrees(n2));
        Assertions.assertEquals(expected3, numTrees(n3));
        Assertions.assertEquals(expected4, numTrees(n4));
        Assertions.assertEquals(expected5, numTrees(n5));
        Assertions.assertEquals(expected6, numTrees(n6));
    }

    @Test
    void testNumTrees2() {
        Assertions.assertEquals(expected1, numTrees2(n1));
        Assertions.assertEquals(expected2, numTrees2(n2));
        Assertions.assertEquals(expected3, numTrees2(n3));
        Assertions.assertEquals(expected4, numTrees2(n4));
        Assertions.assertEquals(expected5, numTrees2(n5));
        Assertions.assertEquals(expected6, numTrees2(n6));
    }
}

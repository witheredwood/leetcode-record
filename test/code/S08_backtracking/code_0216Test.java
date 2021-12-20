package code.S08_backtracking;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
class code_0216Test extends code_0216 {
    int n1 = 7, k1 = 3;
    int[][] expected1 = {{1, 2, 4}};

    int n2 = 9, k2 = 3;
    int[][] expected2 = {{1, 2, 6}, {1, 3, 5}, {2, 3, 4}};

    @Test
    void testCombinationSum3() {
        System.out.println(combinationSum3(k1, n1));
        System.out.println("---------------");
        System.out.println(combinationSum3(k2, n2));
    }

    @Test
    void testCombinationSum32() {
        System.out.println(combinationSum32(k1, n1));
        System.out.println("---------------");
        System.out.println(combinationSum32(k2, n2));
    }
}

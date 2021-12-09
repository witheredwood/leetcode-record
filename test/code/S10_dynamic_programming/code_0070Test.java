package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
class code_0070Test extends code_0070 {
    int n1 = 1, expected1 = 1;
    int n2 = 2, expected2 = 2;
    int n3 = 3, expected3 = 3;

    @Test
    void testClimbStairs() {
        Assertions.assertEquals(expected1, climbStairs(n1));
        Assertions.assertEquals(expected2, climbStairs(n2));
        Assertions.assertEquals(expected3, climbStairs(n3));
    }
}

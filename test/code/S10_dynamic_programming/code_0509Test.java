package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */
class code_0509Test extends code_0509 {
    int n1 = 2, expected1 = 1;
    int n2 = 3, expected2 = 2;
    int n3 = 4, expected3 = 3;
    int n4 = 0, expected4 = 0;

    @Test
    void testFib() {
        Assertions.assertEquals(expected1, fib(n1));
        Assertions.assertEquals(expected2, fib(n2));
        Assertions.assertEquals(expected3, fib(n3));
        Assertions.assertEquals(expected4, fib(n4));
    }

    @Test
    void testFib2() {
        Assertions.assertEquals(expected1, fib2(n1));
        Assertions.assertEquals(expected2, fib2(n2));
        Assertions.assertEquals(expected3, fib2(n3));
        Assertions.assertEquals(expected4, fib2(n4));
    }

    @Test
    void testFib3() {
        Assertions.assertEquals(expected1, fib3(n1));
        Assertions.assertEquals(expected2, fib3(n2));
        Assertions.assertEquals(expected3, fib3(n3));
        Assertions.assertEquals(expected4, fib3(n4));
    }
}

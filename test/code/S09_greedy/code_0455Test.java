package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 */
class code_0455Test extends code_0455 {
    int[] g1 = {1, 2, 3}, s1 = {1, 1};
    int expected1 = 1;

    int[] g2 = {1, 2}, s2 = {1, 2, 3};
    int expected2 = 2;

    @Test
    void testFindContentChildren() {
        Assertions.assertEquals(expected1, findContentChildren(g1, s1));
        System.out.println("-------------------------");
        Assertions.assertEquals(expected2, findContentChildren(g2, s2));
        System.out.println("-------------------------");
        Assertions.assertEquals(0, findContentChildren(new int[]{4, 5}, new int[]{1, 2, 3}));
    }
}

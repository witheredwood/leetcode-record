package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1:
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
class code_0134Test extends code_0134 {
    int[] gas1 = {1, 2, 3, 4, 5}, cost1 = {3, 4, 5, 1, 2};
    int expected1 = 3;

    int[] gas2 = {2, 3, 4}, cost2 = {3, 4, 3};
    int expected2 = -1;

    int[] gas3 = {0, 0, 2}, cost3 = {0, 1, 0};
    int expected3 = 2;

    int[] gas4 = {5, 1, 2, 3, 4}, cost4 = {4, 4, 1, 5, 1};
    int expected4 = 4;

    @Test
    void testCanCompleteCircuit1() {
        Assertions.assertEquals(expected1, canCompleteCircuit(gas1, cost1));
        System.out.println("--------------------");
        Assertions.assertEquals(expected2, canCompleteCircuit(gas2, cost2));
        System.out.println("--------------------");
        Assertions.assertEquals(expected3, canCompleteCircuit(gas3, cost3));
        System.out.println("--------------------");
        Assertions.assertEquals(expected4, canCompleteCircuit(gas4, cost4));
    }

    @Test
    void testCanCompleteCircuit2() {
        Assertions.assertEquals(expected1, canCompleteCircuit2(gas1, cost1));
        System.out.println("--------------------");
        Assertions.assertEquals(expected2, canCompleteCircuit2(gas2, cost2));
        System.out.println("--------------------");
        Assertions.assertEquals(expected3, canCompleteCircuit2(gas3, cost3));
        System.out.println("--------------------");
        Assertions.assertEquals(expected4, canCompleteCircuit2(gas4, cost4));
    }
}

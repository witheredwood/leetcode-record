package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 */
class code_0474Test extends code_0474 {
    String[] strs1 = {"10", "0001", "111001", "1", "0"};
    int m1 = 5, n1 = 3, expected1 = 4;

    String[] strs2 = {"10", "0001", "111001", "1", "0"};
    int m2 = 3, n2 = 3, expected2 = 3;

    String[] strs3 = {"10", "1", "0"};
    int m3 = 1, n3 = 1, expected3 = 2;

    @Test
    void testFindMaxForm() {
        Assertions.assertEquals(expected1, findMaxForm(strs1, m1, n1));
        System.out.println("--------------------------");
        Assertions.assertEquals(expected2, findMaxForm(strs2, m2, n2));
        System.out.println("--------------------------");
        Assertions.assertEquals(expected3, findMaxForm(strs3, m3, n3));
    }
}

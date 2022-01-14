package code.S09_greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

/**
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 */
class code_0135Test extends code_0135 {
    int[] ratings1 = {1, 0, 2};
    int expected1 = 5;

    int[] ratings2 = {1, 2, 2};
    int expected2 = 4;

    int[] ratings3 = {1, 3, 2, 2, 1};
    int expected3 = 7;

    @Test
    void testCandy() {
        Assertions.assertEquals(expected1, candy(ratings1));
        System.out.println("-----------------------");
        Assertions.assertEquals(expected2, candy(ratings2));
        System.out.println("-----------------------");
        Assertions.assertEquals(expected3, candy(ratings3));
    }
}

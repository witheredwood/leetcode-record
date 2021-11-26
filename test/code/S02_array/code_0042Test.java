package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
class code_0042Test extends code_0042 {
    int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int expected1 = 6;

    int[] height2 = {4, 2, 0, 3, 2, 5};
    int expected2 = 9;

    @Test
    void testInsert() {
        System.out.println("intervals = " + Arrays.toString(height1));
        Assertions.assertEquals(expected1, trap(height1));
    }

    @Test
    void testInsert2() {
        System.out.println("intervals = " + Arrays.toString(height2));
        Assertions.assertEquals(expected2, trap(height2));
    }
}

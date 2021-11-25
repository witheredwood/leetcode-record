package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 * 示例 6：
 * 输入：nums = [-2,-1]
 * 输出：-1
 */
class code_0053Test extends code_0053 {
    int[] num1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int expected1 = 6;

    int[] num2 = {1};
    int expected2 = 1;

    int[] num3 = {0};
    int expected3 = 0;

    int[] num4 = {-1};
    int expected4 = -1;

    int[] num5 = {-100000};
    int expected5 = -100000;

    int[] num6 = {-2, -1};
    int expected6 = -1;

    int[] num7 = {-2, -3, -1};
    int expected7 = -1;

    int[] num8 = {8, -19, 5, -4, 20};
    int expected8 = 21;

    int[] num9 = {5, 4, -1, 7, 8};
    int expected9 = 23;


    @Test
    void testMaxSubArray() {
        System.out.println("nums = " + Arrays.toString(num1));
        Assertions.assertEquals(expected1, maxSubArray(num1));
    }

    @Test
    void testMaxSubArray2() {
        System.out.println("nums = " + Arrays.toString(num2));
        Assertions.assertEquals(expected2, maxSubArray(num2));
    }

    @Test
    void testMaxSubArray3() {
        System.out.println("nums = " + Arrays.toString(num3));
        Assertions.assertEquals(expected3, maxSubArray(num3));
    }

    @Test
    void testMaxSubArray4() {
        System.out.println("nums = " + Arrays.toString(num4));
        Assertions.assertEquals(expected4, maxSubArray(num4));
    }

    @Test
    void testMaxSubArray5() {
        System.out.println("nums = " + Arrays.toString(num5));
        Assertions.assertEquals(expected5, maxSubArray(num5));
    }

    @Test
    void testMaxSubArray6() {
        System.out.println("nums = " + Arrays.toString(num6));
        Assertions.assertEquals(expected6, maxSubArray(num6));
    }

    @Test
    void testMaxSubArray7() {
        System.out.println("nums = " + Arrays.toString(num7));
        Assertions.assertEquals(expected7, maxSubArray(num7));
    }

    @Test
    void testMaxSubArray8() {
        System.out.println("nums = " + Arrays.toString(num8));
        Assertions.assertEquals(expected8, maxSubArray(num8));
    }

    @Test
    void testMaxSubArray9() {
        System.out.println("nums = " + Arrays.toString(num9));
        Assertions.assertEquals(expected9, maxSubArray(num9));
    }
}

package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
class code_0283Test extends code_0283 {
    int[] nums = {0, 1, 0, 3, 12};
    int[] expected = {1, 3, 12, 0, 0};

    @Test
    void testMoveZeroes() {
        System.out.println("nums = " + Arrays.toString(nums));
        moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);
    }
}

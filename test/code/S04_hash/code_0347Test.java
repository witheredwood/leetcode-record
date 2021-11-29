package code.S04_hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
class code_0347Test extends code_0347 {
    int[] nums1 = {1,1,1,2,2,3};
    int k1 = 2;
    int[] expected1 = {1,2};

    int[] nums2 = {1};
    int k2 = 1;
    int[] expected2 = {1};

    @Test
    void testTopKFrequent() {
        System.out.println("---------------------------------");
        Assertions.assertArrayEquals(expected1, topKFrequent(nums1, k1));
        System.out.println("---------------------------------");
        Assertions.assertArrayEquals(expected2, topKFrequent(nums2, k2));
    }
}

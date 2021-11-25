package code.S02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 */
class code_0057Test extends code_0057 {
    int[][] intervals1 = {{1, 3}, {6, 9}};
    int[] newInterval1 = {2, 5};
    int[][] expected1 = {{1, 5}, {6, 9}};

    int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newInterval2 = {4, 8};
    int[][] expected2 = {{1, 2}, {3, 10}, {12, 16}};

    int[][] intervals3 = {};
    int[] newInterval3 = {5, 7};
    int[][] expected3 = {{5, 7}};

    int[][] intervals4 = {{1, 5}};
    int[] newInterval4 = {2, 3};
    int[][] expected4 = {{1, 5}};

    int[][] intervals5 = {{1, 5}};
    int[] newInterval5 = {2, 7};
    int[][] expected5 = {{1, 7}};

    @Test
    void testInsert() {
        Assertions.assertArrayEquals(expected1, insert(intervals1, newInterval1));
        System.out.println("--------------------------");
        Assertions.assertArrayEquals(expected2, insert(intervals2, newInterval2));
        System.out.println("--------------------------");
        Assertions.assertArrayEquals(expected3, insert(intervals3, newInterval3));
        System.out.println("--------------------------");
        Assertions.assertArrayEquals(expected4, insert(intervals4, newInterval4));
        System.out.println("--------------------------");
        Assertions.assertArrayEquals(expected5, insert(intervals5, newInterval5));
    }
}

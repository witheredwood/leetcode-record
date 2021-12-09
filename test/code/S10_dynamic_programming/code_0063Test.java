package code.S10_dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 */
class code_0063Test extends code_0063 {
    int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int expected1 = 2;

    int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
    int expected2 = 1;

    int[][] obstacleGrid3 = {{1, 0}};
    int expected3 = 0;
    @Test
    void testUniquePathsWithObstacles() {
        Assertions.assertEquals(expected1, uniquePathsWithObstacles(obstacleGrid1));
        Assertions.assertEquals(expected2, uniquePathsWithObstacles(obstacleGrid2));
        Assertions.assertEquals(expected3, uniquePathsWithObstacles(obstacleGrid3));
    }

    @Test
    void testUniquePathsWithObstacles2() {
        Assertions.assertEquals(expected1, uniquePathsWithObstacles2(obstacleGrid1));
        Assertions.assertEquals(expected2, uniquePathsWithObstacles2(obstacleGrid2));
        Assertions.assertEquals(expected3, uniquePathsWithObstacles2(obstacleGrid3));
    }
}

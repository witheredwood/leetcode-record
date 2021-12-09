package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0063 {
    /**
     * 动态规划
     * 使用二维数组存储 dp[i][j]：从 [1,1] 到 [m][n] 不同路径的总数，
     * 如果某格是障碍物，则路径总数是 0
     * 递推公式 / 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 初始化 dp[1][1]=1
     * 推导 dp 数组。以 obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] 为例，dp 数组：
     * [0,0,0,0]
     * [0,1,1,1]
     * [0,1,0,1]
     * [0,1,1,2]
     *
     * @param obstacleGrid 标识障碍物状态的网格
     * @return 左上角到右下角不同的路径的总数
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[row][col];
    }

    /**
     * 动态规划
     * 使用二维数组存储 dp[i][j]：从 [0,0] 到 [m-1][n-1] 不同路径的总数，
     * 如果某格是障碍物，则路径总数是 0
     * 递推公式 / 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 初始化 dp[1][1]=1
     * 推导 dp 数组。以 obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] 为例，dp 数组：
     * [1,1,1]
     * [1,0,1]
     * [1,1,2]
     *
     * @param obstacleGrid 标识障碍物状态的网格
     * @return 左上角到右下角不同的路径的总数
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        // 第一列全为1，除障碍物外
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0) dp[i][0] = dp[i - 1][0];
        }
        // 第一行全为1，除障碍物外
        for (int j = 1; j < col; j++) {
            if (obstacleGrid[0][j] == 0) dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[row - 1][col - 1];
    }
}

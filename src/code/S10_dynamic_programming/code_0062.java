package code.S10_dynamic_programming;

/**
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0062 {

    /**
     * time:(m*n);     space: O(m*n)
     *
     * @param m 二维数组的行数
     * @param n 二维数组的列数
     * @return 从 [0,0] 到 [m-1,n-1] 有多少条路径
     */
    public int uniquePaths31(int m, int n) {
        int[][] paths = new int[m][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        // 求其他路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    /**
     * 递归
     * 时间复杂度太大，需要优化
     *
     * @param m 网格的行数 / 数组的行数
     * @param n 网格的列数 / 数组的列数
     * @return 从 [0,0] 到 [m-1,n-1] 有多少条路
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1)
            return 1;
        if (m == 0 || n == 0)
            return 0;
        return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
    }

    /**
     * 动态规划
     * 以空间换时间，存储递归中的数据
     * 用二维数组存储, dp[i][j]：从 [1,1] 到 [i,j] 有多少条路 ( 1<=i<=m, 1<=j<=n )
     * 递推公式 / 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 初始化。dp[1][1] = 1
     * 推导 dp 数组。以 m=3,n=7 为例， dp(m+1)(n+1):
     * [0, 0, 0, 0, 0, 0, 0, 0]
     * [0, 1, 1, 1, 1, 1, 1, 1]
     * [0, 1, 2, 3, 4, 5, 6, 7]
     * [0, 1, 3, 6,10,15,21,28]
     * 时间复杂度 O（m*n），空间复杂度 O（m*n）
     *
     * @param m 网格的行数 / 数组的行数
     * @param n 网格的列数 / 数组的列数
     * @return 从 [1,1] 到 [m,n] 有多少条路
     */
    public int uniquePaths2(int m, int n) {
        int[][] array = new int[m + 1][n + 1];
        array[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                array[i][j] = array[i - 1][j] + array[i][j - 1];
        }
        return array[m][n];
    }

    /**
     * 动态规划
     * 以空间换时间，存储递归中的数据，数组存储下标从 0 开始
     * 用二维数组存储, dp[i][j]：从 [0,0] 到 [i,j] 有多少条路 ( 0<=i<m, 0<=j<n )
     * 递推公式 / 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 初始化。dp[0][0] = 1
     * 推导 dp 数组。以 m=3,n=7 为例， dp(m)(n):
     * [1, 1, 1, 1, 1, 1, 1]
     * [1, 2, 3, 4, 5, 6, 7]
     * [1, 3, 6,10,15,21,28]
     * 时间复杂度 O（m*n），空间复杂度 O（m*n）
     *
     * @param m 网格的行数 / 数组的行数
     * @param n 网格的列数 / 数组的列数
     * @return 从 [0,0] 到 [m-1,n-1] 有多少条路
     */
    public int uniquePaths3(int m, int n) {
        int[][] array = new int[m][n];
        array[0][1] = 1;
        // 第一行全为1
        for (int j = 0; j < n; j++)
            array[0][j] = 1;
        // 第一列全为1
        for (int i = 0; i < m; i++)
            array[i][0] = 1;
        // 其余等于上一个+左一个
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                array[i][j] = array[i - 1][j] + array[i][j - 1];
        }
        return array[m - 1][n - 1];
    }

}

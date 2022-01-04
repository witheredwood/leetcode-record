package code.S02_array;

import java.util.Arrays;

/**
 * 59.螺旋矩阵II
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0059 {
    /**
     * @param n 整数
     * @return 螺旋矩阵
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1;
        int num = 1;
        while (left <= right) {
            for (int col = left; col < right; col++) {
                res[left][col] = num++;
            }
            for (int row = left; row < right; row++) {
                res[row][right] = num++;
            }
            for (int col = right; col > left; col--) {
                res[right][col] = num++;
            }
            for (int row = right; row > left; row--) {
                res[row][left] = num++;
            }
            left++;
            right--;
        }
        if (n % 2 == 1) {
            res[n / 2][n / 2] = num;
        }
        System.out.println(Arrays.deepToString(res));
        return res;
    }
}

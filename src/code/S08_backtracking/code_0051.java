package code.S08_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 第51题. N皇后
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 提示：
 * 1 <= n <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0051 {
    /**
     * 回溯
     *
     * @param n 皇后的个数
     * @return 不同的 n 皇后问题 的解决方案
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ".";
            }
        }
        System.out.println("matrix => \n" + Arrays.deepToString(matrix));
        backtracking(matrix, 0, res);
        return res;
    }

    /**
     * @param matrix n 皇后存放矩阵
     * @param row 行数
     */
    public void backtracking(String[][] matrix, int row, List<List<String>> res) {
        if (row >= matrix.length) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < matrix.length; i++) {
                String oneRow = "";
                for (int j = 0; j < matrix.length; j++) {
                    oneRow += matrix[i][j];
                }
                list.add(oneRow);
            }
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!canSet(matrix, row, i)) continue;
            matrix[row][i] = "Q";
            backtracking(matrix, row + 1, res);
            matrix[row][i] = ".";
        }
    }

    /**
     * 是否可以放置皇后
     *
     * @param matrix n 皇后存放矩阵
     * @param row    第几行
     * @param col    第几列
     * @return 该坐标是否可以放置皇后
     */
    public boolean canSet(String[][] matrix, int row, int col) {
        int len = matrix.length;
        // 同一行是否有皇后
        for (int i = 0; i < len; i++) {
            if ("Q".equals(matrix[row][i])) return false;
        }
        // 同一列是否有皇后
        for (int i = 0; i < len; i++) {
            if ("Q".equals(matrix[i][col])) return false;
        }
        // 同一斜线是否有皇后
        for (int i = row, j = col; i < len && j < len; i++, j++) {
            if ("Q".equals(matrix[i][j])) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(matrix[i][j])) return false;
        }
        for (int i = row, j = col; i >= 0 && j < len; i--, j++) {
            if ("Q".equals(matrix[i][j])) return false;
        }
        for (int i = row, j = col; i < len && j >= 0; i++, j--) {
            if ("Q".equals(matrix[i][j])) return false;
        }
        return true;
    }
}

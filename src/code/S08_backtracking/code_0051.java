package code.S08_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
     * 用二维数组存储路径。
     * 如果用List<StringBuilder> 存储路径，会消耗较多的时间，大概是因为子字符串频繁的修改
     *
     * @param n 皇后的个数
     * @return 不同的 n 皇后问题 的解决方案
     */
    public List<List<String>> solveNQueens31(int n) {
        Set<List<String>> result = new HashSet<>();
        Character[][] path = new Character[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = '.';
            }
        }
        backtracking(0, n, path, result);
        return new ArrayList<>(result);
    }

    private void backtracking(int row, int n, Character[][] path, Set<List<String>> result) {
        if (row == n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    builder.append(path[i][j]);
                }
                list.add(builder.toString());
            }
            result.add(list);
            return;
        }
        // 该行放一个皇后
        for (int col = 0; col < n; col++) {
            // 检查该位置是否能放皇后，不能放能看下一个位置
            if (!isHaveOtherQueue(row, col, path)) continue;
            path[row][col] = 'Q';
            backtracking(row + 1, n, path, result);
            path[row][col] = '.';
        }
    }

    private boolean isHaveOtherQueue(int row, int col, Character[][] path) {
        // 同列无其他皇后
        for (int r = 0; r < row; r++) {
            if (path[r][col] == 'Q') return false;
        }
        // 从右到左无其他皇后
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (path[r][c] == 'Q') return false;
        }
        // 从左到右无其他皇后
        for (int r = row, c = col; r >= 0 && c < path.length; r--, c++) {
            if (path[r][c] == 'Q') return false;
        }
        return true;
    }

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
     * @param row    行数
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

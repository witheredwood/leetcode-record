package code.S08_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 37. 解数独
 * <p>
 * 编写一个程序，通过填充空格来解决数独问题。
 * 一个数独的解法需遵循如下规则： 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 空白格用 '.' 表示。
 * <p>
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * 提示：
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0037 {
    /**
     * @param board 数独矩阵
     */
    public void solveSudoku(char[][] board) {
        List<Integer> list = new LinkedList<>();
        int n = 0;
        while (n < 81) {
            int row = n / 9, col = n % 9;
            if (board[row][col] == '.') list.add(n);
            n++;
        }
        backtracking(board, list, 0);
    }

    /**
     * 回溯算法
     *
     * @param board 数独矩阵
     * @param list  需要填写的数字列表
     * @param index 数字列表 list 中的下标
     * @return 是否找到一种可以填写的数独方案
     */
    public boolean backtracking(char[][] board, List<Integer> list, int index) {
        if (index >= list.size()) {
            return true;
        }
        int n = list.get(index);
        int row = n / 9, col = n % 9;
        for (char c = '1'; c <= '9'; c++) {
            if (!isCanSet(board, row, col, c)) continue;
            board[row][col] = c;
            if (backtracking(board, list, index + 1)) return true;
            board[row][col] = '.';
        }
        return false;
    }

    /**
     * 判断矩阵中的某个坐标 [row, col]是否可以填数字 digit
     *
     * @param board 数独矩阵
     * @param row   第几行
     * @param col   第几列
     * @param digit 数字
37     * @return 该位置上是否可以填数字 digit
     */
    public boolean isCanSet(char[][] board, int row, int col, char digit) {
        // 同一行中是否可以放置该数字
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false;
        }
        // 同一列中是否可以放置该数字
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) return false;
        }
        // 同一方块中是否可以放置该数字
        int startRow = row / 3 * 3;  // [row, col] 所在方格的起始横坐标
        int startCol = col / 3 * 3;  // [row, col] 所在方格的起始纵坐标
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }
        return true;
    }
}

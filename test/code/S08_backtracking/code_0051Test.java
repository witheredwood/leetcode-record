package code.S08_backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 */
class code_0051Test extends code_0051 {
    int n1 = 4;
    int n2 = 1;

    @Test
    void testSolveNQueens() {
        System.out.println(solveNQueens(n1));
    }

    @Test
    void testSolveNQueens2() {
        System.out.println(solveNQueens(n2));
    }
}

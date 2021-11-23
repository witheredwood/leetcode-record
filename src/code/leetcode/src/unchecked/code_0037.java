package unchecked;

import java.util.*;

public class code_0037 {
    int n = 0, cur = 0;
    public void solveSudoku(char[][] board) {
        //初始化已有数字
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    n++;
                }
            }
        }

        // 找到第一个要填的位置
        int i = 0, j = 0;
        while (board[i][j] != '.') {
            j++;

        }
        for (int l = 1; l < 10; l++) {
            char c = (char)('0'+l);
            if (isValid(board, i, j, c)) {
                dfs(board, i, j, c);
                if (cur<n) {
                    board[i][j] = '.';
                    cur--;
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j, char k) {
        board[i][j] = k;
        cur++;

//        // 结束条件
        if (cur >= n){
            System.out.println("???????????");
            return;
        }

        // 找到下一个要填的位置
         do {
            j++;
            if (j == 9){
                i++;
                j = 0;
            }
        }while (board[i][j] != '.');

        // 可供选择的列表
        for (int l = 1; l < 10; l++) {
            char c = (char)('0'+l);
            if (isValid(board, i, j, c)) {
                dfs(board, i, j, c);
                if (cur<n) {
                    board[i][j] = '.';
                    cur--;
                }
            }
        }

    }
    //
    public boolean isValid(char[][] board, int i, int j, char c) {
        // 排除行
        for (int k = 0; k < 9; k++) {
            if (c == board[i][k]) return false;
        }
        // 排除列
        for (int k = 0; k < 9; k++) {
            if (c == board[k][j]) return false;
        }
        // 排除块
        int row = i/3*3, col = j/3*3;  // 当前位置所在块的起始位置
        for (int k = row; k < row+3; k++) {
            for (int l = col; l < col+3; l++) {
                if (c == board[k][l]) return false;
            }
        }
        return true;
    }
}

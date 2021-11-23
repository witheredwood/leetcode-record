package leetcode_code;

import java.util.List;

public class code_0051_Main {
    public static void main(String[] args) {
        code_0051 one = new code_0051();

        List<List<String>> res = one.solveNQueens(4);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

        List<List<String>> res1 = one.solveNQueens(1);
        for (int i = 0; i < res1.size(); i++) {
            System.out.println(res1.get(i));
        }
    }

}

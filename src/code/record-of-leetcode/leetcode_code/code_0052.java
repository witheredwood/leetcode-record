package leetcode_code;

public class code_0052 {
    int num = 0;
    public int totalNQueens(int n) {
        // 初始化矩阵
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '.';
            }
        }
        // 从第一行开始放置皇后
        for (int j = 0; j < n; j++) {
            dfs(0, j, arr);  // 访问该节点
            arr[0][j] = '.';  // 将该节点置空
        }

        return num;
    }

    public void dfs(int i, int j, char[][] arr) {
//        stack.push(i);
//        System.out.println("-------------");
//        System.out.println("i="+i+" j="+j);
//        System.out.println("stack="+stack);

        // 该位置不能放置皇后，结束遍历
        if (!isValid(i, j, arr)) return;

        arr[i][j] = 'Q';

        // 找到一条可行的路径，添加到最终结果中
        if (i == arr.length-1) {
            num++;
//            System.out.println("num="+num);
            return;
        }

        for (int k = 0; k < arr.length; k++) {
            dfs(i+1, k, arr);
            arr[i+1][k] = '.';
        }

    }



    // 判断该位置[i,j]是否能放置皇后
    public boolean isValid(int i, int j, char[][] arr) {
        // 判断同一行是否有皇后
        for (int k = 0; k < arr.length; k++) {
            if (arr[i][k] == 'Q') return false;
        }
        // 判断同一列是否有皇后
        for (int k = 0; k < arr.length; k++) {
            if (arr[k][j] == 'Q') return false;
        }
        // 判断两条斜线是否有皇后
        for (int k=i-1, m=j-1; k >= 0 && m >= 0; k--, m--) {
            if (arr[k][m] == 'Q') return false;
        }
        for (int k=i+1, m=j+1; k < arr.length && m < arr.length; k++, m++) {
            if (arr[k][m] == 'Q') return false;
        }

        for (int k=i-1, m=j+1; k >= 0 && m < arr.length; k--, m++) {
            if (arr[k][m] == 'Q') return false;
        }
        for (int k=i+1, m=j-1; k < arr.length && m >= 0; k++, m--) {
            if (arr[k][m] == 'Q') return false;
        }
        return true;
    }
}

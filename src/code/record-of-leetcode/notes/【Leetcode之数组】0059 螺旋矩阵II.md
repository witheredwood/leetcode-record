# 【Leetcode之数组】0059 螺旋矩阵II

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/spiral-matrix-ii/

语言：Java

##  题目

给你一个正整数 `n` ，生成一个包含 `1` 到 `n2` 所有元素，且元素按顺时针顺序螺旋排列的 `n x n` 正方形矩阵 `matrix` 。

<img src="【Leetcode之数组】0059 .assets/21.jpg" alt="21" style="zoom:50%;" />

**示例**

```
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]

输入：n = 1
输出：[[1]]
```

## 方法：模拟

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];  //dynamic initialization
        int count = 1;
        int i,j;
        for (int left=0,right=n-1; left<=right; left++,right--) {  
            // traverse this row
            for (i=left,j=left; j<right && count<=n*n; j++,count++)
                matrix[i][j] = count;
            // traverse this column
            for (i=left,j=right; i<right && count<=n*n; i++,count++) 
                matrix[i][j] = count;
            // traverse this row
            for (i=right,j=right; j>left && count<=n*n; j--,count++)
                matrix[i][j] = count;
            // traverse this column
            for (i=right,j=left; i>left && count<=n*n; i--,count++) 
                matrix[i][j] = count;
        }
        // when n is a count, the last value can not be traverse
        if (count==n*n) matrix[n/2][n/2] = count;
        return matrix;
    }
}
```

时间复杂度：O(n^2)		空间复杂度：O(n^2)

执行用时：0 ms

内存消耗：36.7 MB

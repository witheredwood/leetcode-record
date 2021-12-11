package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 */
public class code_0096 {
    /**
     * 动态规划
     * 使用一维数组存储 dp[i]: i 个节点组成互不相同的儿茶搜索树的种数
     * 递推公式 / 状态转移方程 dp[i] = 2*(d[i-1] + dp[i-2]*dp[1] + ... + dp[i/2]*dp[i/2])  i 为偶数
     * dp[i] = 2*(d[i-1] + dp[i-2]*dp[1] + ... + dp[i/2+1]*dp[i-i/2]) + dp[i/2]*dp[i/2]  i 为奇数
     * 初始化 dp[2]=2,dp[1]=1.为了代码中程序方便，令 dp[0]=1。经过测试，初始化 dp[0]=1 后不需要初始化 dp[1] 和 dp[2]
     * 推导递推公式
     * dp[4] = [(1),1,2,5,14]
     *
     * @param n 整数
     * @return 互不相同的二叉搜索树的种数
     */
    public int numTrees(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = i - 1; k >= i / 2; k--) {
                dp[i] += dp[k] * dp[i - 1 - k];
            }
            dp[i] *= 2;
            dp[i] -= i % 2 == 0 ? 0 : dp[i / 2] * dp[i / 2];
        }
        System.out.println("n = " + n + " " + Arrays.toString(dp));
        return dp[n];
    }

    /**
     * 动态规划
     * 递推公式 / 状态转移方程 dp[i] = dp[0]*d[i-1] + dp[1]*dp[i-2] + ... + dp[i-1]*dp[0]
     * 这个递推公式更好理解
     *
     * @param n 整数
     * @return 互不相同的二叉搜索树的种数
     */
    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < i; k++) {
                dp[i] += dp[k] * dp[i - 1 - k];
            }
        }
        System.out.println("n = " + n + " " + Arrays.toString(dp));
        return dp[n];
    }
}

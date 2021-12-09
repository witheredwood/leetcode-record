package code.S10_dynamic_programming;

/**
 * 509. 斐波那契数
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *  
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 提示：
 * 0 <= n <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0509 {
    /**
     * 递归
     *
     * @param n 整数
     * @return 斐波那契数
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划
     * 使用一维数组保存斐波那契数 dp[i]: 第i个数的斐波那契数
     * 状态转移方程 / 递推公式 dp[i] = dp[i-1] + dp[i-2]
     * 初始化 由 i-2>=0  => i>=2，所以需要给出 dp[0] 和 dp[1]
     * 推导 dp 数组  dp(10): 0 1 1 2 3 5 8 13 21 34 55
     * 时间复杂度 O（n） 空间复杂度 O（n）
     *
     * @param n 整数
     * @return 斐波那契数
     */
    public int fib2(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = 1;
        // 通过递推公式求状态转移数组
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 动态规划
     * 从 fib2() 中发现，整个过程，只需要维护 dp[i-1] 和 dp[i-2] 两个数，
     * 可以不记录整个序列
     * 时间复杂度 O（n） 空间复杂度 O（1）
     *
     * @param n 整数
     * @return 斐波那契数
     */
    public int fib3(int n) {
        if (n <= 1) return n;
        int[] dp = new int[2];
        // 初始化
        dp[0] = 0;
        dp[1] = 1;
        int sum = 0;
        // 通过递推公式求状态转移数组
        for (int i = 2; i <= n; i++) {
            sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return sum;
    }
}

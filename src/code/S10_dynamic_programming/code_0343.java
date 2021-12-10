package code.S10_dynamic_programming;

import java.util.Arrays;
import java.util.Map;

/**
 * 343. 整数拆分
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0343 {
    /**
     * 动态规划
     * 使用一维数组存储 dp[i]: 将 n 拆分为多个整数后，它们的乘积
     * 递推数组 / 动态转移方程 dp[i] = max{f(k),f(k-1) ... f(1) },
     * 其中, k=n/2, f(k) = k * max{(n-k), dp[n-k]}
     * 初始化 由 n/2>=1 => n>=2，所以初始化 dp[2] 和 dp[1]
     * 推导 dp 数组，以 dp[10] 为例：
     * [(0),1,1,2,4,6,9,12,18,24,36]
     *
     * @param n 整数
     * @return 拆分成的所有数的乘积
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int k = i / 2; k > 0; k--) {
                dp[i] = Math.max(dp[i], k * Math.max(i - k, dp[i - k]));
            }
        }
        return dp[n];
    }
}

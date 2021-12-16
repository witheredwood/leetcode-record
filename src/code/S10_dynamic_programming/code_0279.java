package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 279.完全平方数
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *  
 * 提示：
 * 1 <= n <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0279 {
    /**
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;  // 初始化
        int size = (int) (Math.sqrt(n));
        System.out.println("size = " + size);
        for (int i = 0; i <= size; i++) {  // 物品
            for (int j = i * i; j <= n; j++) {  // 背包
                // 比如 12 = 4 + 9，只有当 dp[9] 的最少数量不是 Integer.MAX_VALUE 时，才能计算，
                // 否则说明此时的背包容量不能由完全平方数组成
                if (dp[j - i * i] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}

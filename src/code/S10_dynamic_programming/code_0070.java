package code.S10_dynamic_programming;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0070 {
    /**
     * 递归
     * 到达n阶的有两种方法： 到达（n-1）阶楼梯后爬1个台阶，到达（n-2）阶楼梯后爬2个台阶。
     * 所以，到达n阶楼梯的方法总数 = 到达（n-1）阶楼梯的方法总数 + 到达（n-2）阶楼梯的方法总数
     * 递推公式 c(n) = c(n-1) + c(n-2)
     *
     * @param n 楼梯总阶数
     * @return 有多少中方法到达楼顶
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     * 递推公式 c(n) = c(n-1) + c(n-2)
     *
     * @param n 楼梯总阶数
     * @return 有多少中方法到达楼顶
     */
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}

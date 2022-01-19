package code.S09_greedy;

import java.util.Map;

/**
 * 738. 单调递增的数字
 * <p>
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0738 {
    /**
     * 从高位到低位，依次确定每位上的数字
     * @param n 整数
     * @return 小于 n 的最大的递增整数
     */
    public int monotoneIncreasingDigits(int n) {
        int len = 0; // n 有几位
        for (int i = n; i > 0; ) {
            i = i / 10;
            len++;
        }
        System.out.println("len = " + len);
        int res = 0;
        for (int m = n; m > 0; ) {
            int a = m;  // 计算最高位数字
            while (a > 9) {
                a = a / 10;
            }
            int tmp = 0;  // 最高位数字组成的最小的非递减数字
            for (int i = 0; i < len; i++) {
                tmp += a * Math.pow(10, i);
            }
            System.out.println("a = " + a + " tmp = " + tmp);
            if (tmp > m) {
                res += (int) (a * Math.pow(10, len - 1)) - 1;
                System.out.println("res = " + res);
                return res;
            }
            res += (int) (a * Math.pow(10, len - 1));
            m = m - (int) (a * Math.pow(10, len - 1));
            len--;
            System.out.println("m = " + m + " res = " + res);
        }
        return res;
    }
}

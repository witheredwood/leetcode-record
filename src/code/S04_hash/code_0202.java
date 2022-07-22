package code.S04_hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0202 {
  Set<Integer> set = new HashSet<>();

  /**
   * time: O(logn);    space: O(logn)
   * 处理数字中的每位数字，而数字中的位数由 log n 给定。
   *
   * @param n 正整数
   * @return 是不是快乐数
   */
  public boolean isHappy32(int n) {
    Set<Integer> hashSet = new HashSet<>();
    while (n != 1 && !hashSet.contains(n)) {
      hashSet.add(n);
      int sum = getSquareSum(n);
      n = sum;
    }
    return n == 1;
  }

  /**
   * time: O(计算的平方和的个数);    space: O(计算的平方和的个数)
   *
   * @param n 正整数
   * @return 是不是快乐数
   */
  public boolean isHappy31(int n) {
    if (n == 1) return true;
    int sum = getSquareSum(n);
    if (set.contains(sum)) return false;
    set.add(sum);
    return isHappy31(sum);
  }

  /**
   * @param n 正整数
   * @return 该整数各位置上的平方之和
   */
  private int getSquareSum(int n) {
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;
      sum += digit * digit;
      n = n / 10;
    }
    return sum;
  }
}

package code.S05_string;

/**
 * 541. 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0541 {
  /**
   * time: O(n);      space: O(n)
   *
   * @param s 字符串
   * @param k 整数
   * @return 翻转后的字符串
   */
  public String reverseStr31(String s, int k) {
    char[] chars = s.toCharArray();
    // 反转 0-k
    for (int num = 0; num <= chars.length / k; num += 2) {
      int start = k * num, end = Math.min(k * (num + 1), chars.length);
      char c;
      // 反转 [0, k]*num
      for (int i = start, j = end - 1; i < j; i++, j--) {
        c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
      }
    }
    return new String(chars);
  }

  public String reverseStr(String s, int k) {
    int num = s.length() / k;  // s 中有几个k
    System.out.println("num = " + num);
    for (int i = 0; i <= num; i = i + 2) {
      // 反转 [i, i+1]k 之间的字符串
      int end = (i + 1) * k;
      if (end < s.length()) s = reverse(s, i * k, end);
    }
    // 是否反转剩余的字符
    if (num % 2 == 0) {
      s = reverse(s, num * k, s.length());
    }
    return s;
  }

  public String reverse(String s, int start, int end) {
    if (end > s.length()) return s;
    char[] chars = s.toCharArray();
    for (int i = start, j = end - 1; i < j; i++, j--) {
      char c = chars[i];
      chars[i] = chars[j];
      chars[j] = c;
    }
    return new String(chars);
  }

}

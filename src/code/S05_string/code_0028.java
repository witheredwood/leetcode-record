package code.S05_string;


/**
 * 28. 实现 strStr()
 * <p>
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 * 说明：
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0028 {
  /**
   * time: O(n+m);    space: O(m)
   *
   * @param haystack 字符串
   * @param needle   字符串
   * @return needle 在 haystack 中出现的第一个位置
   */
  public int strStr(String haystack, String needle) {
    int[] next = getNext(needle);
    int i = 0, j = 0;
    while (i < haystack.length() && j < needle.length()) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
        if (j == -1) {
          j = 0;
          i++;
        }
      }
    }
    return j == needle.length() ? i - needle.length() : -1;
  }

  /**
   * 求解next数组 [-1, ... , ...]
   * 利用java的字符串函数比较前缀和后缀是否相等
   *
   * @param s 字符串
   * @return 该字符串的next数组
   */
  private int[] getNext(String s) {
    int[] next = new int[s.length()];
    next[0] = -1;
    // 求next数组
    for (int index = 1; index < s.length(); index++) {
      // 当前index字符之前的子串[0, index-1]的相等的最长前后缀
      for (int i = index - 1, j = 1; i > 0 && j < index; i--, j++) {
        String pre = s.substring(0, i);  // 前缀
        String post = s.substring(j, index);  // 后缀
        if (pre.equals(post)) {   // 前缀和后缀相等的最大长度
          next[index] = i;
          break;
        }
      }
    }
    return next;
  }
}

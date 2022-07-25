package code.S05_string;

/**
 * 434. 字符串中的单词数
 * <p>
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0434 {
  /**
   * time: O(n);      space: O(1)
   * 注：空字符串切分后会有1个长度
   *
   * @param s 字符串
   * @return 字符串中的单词个数
   */
  public int countSegments(String s) {
    s = s.trim();
    if (s.length() == 0) return 0;
    return s.split(" {1,}").length;
  }
}

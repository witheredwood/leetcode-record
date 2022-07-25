package code.S05_string;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_offer05 {
  /**
   * time: O(n);          space: O(1)
   *
   * @param s 字符串
   * @return 字符串 s 中的每个空格替换成"%20"之后的结果
   */
  public String replaceSpace(String s) {
    StringBuilder builder = new StringBuilder(s);
    for (int i = 0; i < builder.length(); i++) {
      // 替换空格
      if (builder.charAt(i) == ' ') {
        builder.replace(i, i + 1, "%20");
      }
    }
    return builder.toString();
  }
}

package code.S05_string;

import java.util.LinkedList;

/**
 * 844. 比较含退格的字符串
 * <p>
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0844 {
  /**
   * time: O(n+m);        space: O(n+m)
   *
   * @param s 字符串
   * @param t 字符串
   * @return 两个字符串是否相等
   */
  public boolean backspaceCompare(String s, String t) {
    return getLastString(s).equals(getLastString(t));
  }

  /**
   * time: O(n);        space: O(n)
   *
   * @param s 字符串
   * @return 经过退格之后得到的字符串
   */
  private String getLastString(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '#') {
        stack.push(s.charAt(i));
      } else {
        if (!stack.isEmpty()) stack.pop();
      }
    }
    return stack.toString();
  }
}

package code.S04_hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s和t由任意有效的 ASCII 字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0205 {
  /**
   * 同构字符串：一一映射，每个位置上映射的字符是相同的
   * */

  /**
   * time: O(s.length());   space: O(s.length())
   *
   * @param s 字符串
   * @param t 字符串
   * @return 两个字符串是否是同构字符串
   */
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    // 遍历字符串s，并记录s和t的映射关系，<s 中的字符，t 中的字符>
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        if (map.containsValue(t.charAt(i))) return false;
        map.put(s.charAt(i), t.charAt(i));
      } else {
        if (t.charAt(i) != map.get(s.charAt(i))) return false;
      }
    }
    return true;
  }
}

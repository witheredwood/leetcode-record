package code.S05_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 767. 重构字符串
 * <p>
 * 给定一个字符串s，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 返回 s的任意可能的重新排列。若不可行，返回空字符串""。
 * <p>
 * 示例1:
 * 输入: s = "aab"
 * 输出: "aba"
 * 示例 2:
 * 输入: s = "aaab"
 * 输出: ""
 * <p>
 * 提示:
 * 1 <= s.length <= 500
 * s 只包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0767 {
  /**
   * time: O(nlogn);        space: O(n)
   *
   * @param s 字符串
   * @return 重排字符串
   */
  public String reorganizeString(String s) {
    // 统计每个字符的个数
    int limit = (s.length() + 1) / 2;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), 1);
      } else {
        map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
        if (map.get(s.charAt(i)) > limit) return "";
      }
    }
    // 排序，降序排列
    List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
    Collections.sort(entryList, (a, b) -> {
      if (a.getValue() != b.getValue()) return b.getValue() - a.getValue();
      return a.getKey() - b.getKey();
    });
    // 重排。先填满偶数位，再填满奇数位
    char[] resultChars = new char[s.length()];
    int index = 0;
    for (Map.Entry<Character, Integer> entry : entryList) {
      for (int i = 0; i < entry.getValue(); i++) {
        resultChars[index] = entry.getKey();
        index += 2;
        if (index >= s.length()) index = 1;
      }
    }
    return new String(resultChars);
  }
}

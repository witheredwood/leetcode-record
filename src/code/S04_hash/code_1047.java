package code.S04_hash;

import java.util.LinkedList;

public class code_1047 {
  /**
   * 栈
   * time: O(n);      space: O(n)
   *
   * @param s 字符串
   * @return 删除相邻重复字符后的字符串
   */
  public String removeDuplicates(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
        stack.push(s.charAt(i));
      } else {
        stack.pop();
      }
    }
    // 结果;
    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.insert(0, stack.pop());
    }
    return builder.toString();
  }
}

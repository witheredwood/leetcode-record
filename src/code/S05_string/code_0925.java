package code.S05_string;

/**
 * 925. 长按键入
 * <p>
 * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
 * <p>
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * <p>
 * 提示：
 * 1 <= name.length, typed.length <= 1000
 * name 和typed的字符都是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0925 {
  /**
   * 比较两个字符串在规则之内是否相等
   * time: O(n+m);      space: O(1)
   *
   * @param name  字符串
   * @param typed 字符串
   * @return 在规则之内，两个字符串是否相等
   */
  public boolean isLongPressedName(String name, String typed) {
    int left1 = 0, right1 = 0, count1 = 0;
    int left2 = 0, right2 = 0, count2 = 0;
    while (right1 <= name.length() && right2 <= typed.length()) {
      // 找到 name 中当前的相同字符，计算其个数
      while (right1 < name.length() && name.charAt(right1) == name.charAt(left1)) right1++;
      count1 = right1 - left1;
      // 找到 typed 中当前的相同字符，计算其个数
      while (right2 < typed.length() && typed.charAt(right2) == typed.charAt(left2)) right2++;
      count2 = right2 - left2;
      // 不符合条件的情况
      if (count1 > count2 || name.charAt(left1) != typed.charAt(left2)) return false;
      left1 = right1;
      left2 = right2;
      right1++;
      right2++;
    }
    return right1 > name.length() && right2 > typed.length();
  }
}

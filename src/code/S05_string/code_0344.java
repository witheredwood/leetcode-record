package code.S05_string;

import java.util.Arrays;

/**
 * 344. 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
 * <p>
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *  
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0344 {
  /**
   * time: O(n);      space: O(1)
   *
   * @param s 字符数组
   */
  public void reverseString31(char[] s) {
    for (int i = 0, j = s.length - 1; i < j; i++, j--) {
      char c = s[i];
      s[i] = s[j];
      s[j] = c;
    }
  }


  /**
   * @param s 字符串
   */
  public void reverseString(char[] s) {
    char t;
    for (int i = 0, j = s.length - 1; i < j; i++, j--) {
      t = s[i];
      s[i] = s[j];
      s[j] = t;
    }
    System.out.println("s = " + Arrays.toString(s));
  }
}

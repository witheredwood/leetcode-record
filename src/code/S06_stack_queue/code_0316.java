package code.S06_stack_queue;

import java.util.LinkedList;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0316 {
    /**
     * @param s 字符串
     * @return 最小字典序的不重复子串
     */
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.size() == 0) stack.addFirst(current);  // 栈空
            if (stack.indexOf(current) == -1) {  // 当前字符不在栈中
                while (stack.size() > 0 && current < stack.getFirst() && s.indexOf(stack.getFirst(), i) > -1) {
                    stack.removeFirst();
                }
                stack.addFirst(current);
            }
        }
        System.out.println("stack = " + stack.toString());
        StringBuilder res = new StringBuilder();
        for (char c : stack) {
            res.insert(0, c);
        }
        System.out.println("res = " + res.toString());
        return res.toString();
    }

//    public String removeDuplicateLetters2(String s) {
//        StringBuilder builder = new StringBuilder();  // 不重复的子串
//        int len = s.length();
//        for (int i = len - 1; i >= 0; i--) {
//            char current = s.charAt(i);  // 当前遍历到的字符
//            // 当前字符不在子串中
//            if (builder.length() == 0 || builder.indexOf(String.valueOf(current)) == -1) {
//                builder.insert(0, current);
//            } else if (current < builder.charAt(0)) {  // 当前字符小于子串的第一个字符时，更新子串
//                builder.deleteCharAt(builder.indexOf(String.valueOf(current)));
//                builder.insert(0, current);
//            }
//        }
//        System.out.println("builder => " + builder.toString());
//        return builder.toString();
//    }
}

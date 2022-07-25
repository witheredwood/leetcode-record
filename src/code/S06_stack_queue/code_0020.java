package code.S06_stack_queue;

import java.util.LinkedList;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0020 {
    /**
     * time: O(n);          space: O(n)
     *
     * @param s 字符串
     * @return 规则之内，子字符串是否有效
     */
    public boolean isValid31(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '[':
                case '(':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.size() == 0 || c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                char top = stack.getLast();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}

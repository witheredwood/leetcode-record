package code.S06_stack_queue;

import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 提示：
 * 1 <= tokens.length <= 104
 * tokens[i]是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0150 {
    /**
     * time: O(n);          space: O(n)
     *
     * @param tokens 算符数组
     * @return 表达式的值
     */
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    int a1 = Integer.parseInt(stack.pop()), b1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a1 + b1));
                    break;
                case "-":
                    int a2 = Integer.parseInt(stack.pop()), b2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b2 - a2));
                    break;
                case "*":
                    int a3 = Integer.parseInt(stack.pop()), b3 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a3 * b3));
                    break;
                case "/":
                    int a4 = Integer.parseInt(stack.pop()), b4 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b4 / a4));
                    break;
                default:
                    stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}

package code.S06_stack_queue;

import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * <p>
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0232 {
    private LinkedList<Integer> stack1 = null;
    private LinkedList<Integer> stack2 = null;

    code_0232() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /**
     * 将元素 x 推到队列的末尾
     *
     * @param x 整数
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * 从队列的开头移除并返回元素
     *
     * @return 队首元素
     */
    public int pop() {
        if (!stack2.isEmpty()) return stack2.pop();
        // 把 stack1 中的元素加入 stack2 中，然后再弹出 stack2 的栈顶
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    /**
     * 返回队列开头的元素
     *
     * @return 队列开头的元素
     */
    public int peek() {
        if (!stack2.isEmpty()) return stack2.peek();
        // 把 stack1 中的元素加入 stack2 中，然后再返回 stack2 的栈顶
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.peek();
    }

    /**
     * 队列是否为空
     *
     * @return 如果队列为空，返回 true ；否则，返回 false
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

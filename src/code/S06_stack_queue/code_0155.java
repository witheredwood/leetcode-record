package code.S06_stack_queue;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 155. 最小栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 提示：
 * -2^31<= val <= 2^31- 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push,pop,top, andgetMin最多被调用3 * 10^4次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0155 {
    LinkedList<Integer> bottom = null;
    private PriorityQueue<Integer> queue = null;  // 对栈中元素排序，方便找到最小值

    /**
     * 初始化堆栈对象
     */
    public code_0155() {
        bottom = new LinkedList<>();
        // 构造优先级队列，并定义排序规则
        queue = new PriorityQueue<>((a, b) -> {
            if (a != b) return (long) a - b > 0 ? 1 : -1;
            return 0;
        });
    }

    /**
     * 将元素val推入堆栈
     *
     * @param val 元素
     */
    public void push(int val) {
        bottom.add(val);
        queue.offer(val);
    }

    /**
     * 删除堆栈顶部的元素
     */
    public void pop() {
        int top = bottom.removeLast();
        queue.remove(top);
    }

    /**
     * 获取堆栈顶部的元素
     *
     * @return 栈顶元素
     */
    public int top() {
        return bottom.getLast();
    }

    public int getMin() {
        return queue.peek();
    }
}

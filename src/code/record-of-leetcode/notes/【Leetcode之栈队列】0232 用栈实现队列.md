# 【Leetcode之栈/队列】0232 用栈实现队列

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/implement-queue-using-stacks

实现语言：Java

@[TOC](目录)

##  题目

请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 `MyQueue` 类：

`void push(int x)` 将元素 x 推到队列的末尾
`int pop()` 从队列的开头移除并返回元素
`int peek()` 返回队列开头的元素
`boolean empty()` 如果队列为空，返回 true ；否则，返回 false


说明：

你只能使用标准的栈操作 —— 也就是只有 `push to top`, `peek/pop from top`, `size`, 和 `is empty` 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 `list` 或者 `deque`（双端队列）来模拟一个栈，只要是标准的栈操作即可。

**进阶：**

- 你能否实现每个操作均摊时间复杂度为 `O(1)` 的队列？换句话说，执行 `n` 个操作的总时间复杂度为 `O(n)` ，即使其中一个操作可能花费较长时间。

**示例**

```
输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
```

## 方法：

**代码实现**

```java
import java.util.Stack;

class MyQueue {
    Stack<Integer> s1,s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // s1未满，入栈到s1
        s1.push(x); 
        return ;    
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // s2 不为空
        if (!s2.empty())  return s2.pop();
        // s2 为空，把s1入栈到s2
        while (!s1.empty()) {
            int tmp = s1.pop();
            s2.push(tmp);
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        // s2 不为空
        if (!s2.empty())  return s2.peek();
        // s2 为空，把s1入栈到s2
        while (!s1.empty()) {
            int tmp = s1.pop();
            s2.push(tmp);
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (s1.empty() && s2.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

执行用时：0 ms

内存消耗：36.2 MB


# 【Leetcode之栈/队列】0232 用队列实现栈

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/implement-stack-using-queues

实现语言：Java

@[TOC](目录)

##  题目

请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（`push`、`top`、`pop` 和 `empty`）。

实现 `MyStack` 类：

`void push(int x)` 将元素 x 压入栈顶。
`int pop()` 移除并返回栈顶元素。
`int top()` 返回栈顶元素。
`boolean empty()` 如果栈是空的，返回 true ；否则，返回 false 。

**注意：**

你只能使用队列的基本操作 —— 也就是 `push to back`、`peek/pop from front`、`size` 和 `is empty` 这些操作。
你所使用的语言也许不支持队列。 你可以使用 `list` （列表）或者 `deque`（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。

**示例**

```
输入：
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 2, 2, false]

解释：
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // 返回 2
myStack.pop(); // 返回 2
myStack.empty(); // 返回 False
```

## 方法：

`LinkedList` 实现了 `List` 接口，可进行列表的相关操作。同时，`LinkedList` 实现了 `Queue` 接口，可作为队列使用。

 在 `Queue` 中， 可使用的函数如下：`add()`、`remove()`、`element()`、`offer()`、`poll()`、`peek()`。

-  `add()`：增加一个元素，队列满了会抛出异常。

- `remove()`：移除队头一个元素并返回该元素，队列空了会抛出异常。

- `element()`：返回队头一个元素，队列空了会抛出异常。

- `offer()`：增加一个元素，队列满了会返回 false。

- `poll()`：移除队头一个元素并返回该元素，队列空了会返回 null。

- `peek()`：返回队头一个元素，队列空了会返回 null。

**代码实现**

```java
import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q1,q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 把q1中的元素移到q2中，只剩下一个元素，然后返回最后一个元素
        while (q1.size() != 1) {
           int tmp = q1.poll();
           q2.offer(tmp);
        }
        int res = q1.poll();
        while (q2.peek()!=null) {
            q1.offer(q2.poll());
        }
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        // 把q1中的元素移到q2中，只剩下一个元素，然后返回最后一个元素
        while (q1.size() != 1) {
           int tmp = q1.poll();
           q2.offer(tmp);
        }
        int res = q1.poll();
        q2.offer(res);
        while (q2.peek()!=null) 
            q1.offer(q2.poll());
        }
        return res;    
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (q1.peek()==null)  return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

执行用时：0 ms

内存消耗：36.5 MB


# 【Leetcode之栈/队列】0155 最小栈

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/min-stack

实现语言：Java

@[TOC](目录)

##  题目

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

**示例**

```
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

**提示：**

- `pop`、`top` 和 `getMin` 操作总是在 **非空栈** 上调用。

## 方法一：数组

如果使用数组实现，数组的最大大小 `MaxSize`  需要设置一个很大的值，才可以通过测试。

**代码实现**

```java
class MinStack {
    int MaxSize = 1000;
    int[][] data;
    int top;
    /** initialize your data structure here. */
    public MinStack() {
        data = new int[MaxSize][2];
        top = -1;
    }
    
    public void push(int val) {
        if (top==MaxSize-1) return;       
        top++;
        data[top][0] = val;   // 入栈
        // 加入当前栈中的最小值
        int min; // 最小值
        if (top==0) min = val; 
        else  min = Math.min(val,data[top-1][1]); 
        data[top][1] = min;
    }
    
    public void pop() {
        top = top - 1;
    }
    
    public int top() {
        return data[top][0];
    }
    
    public int getMin() {
       return data[top][1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

时间复杂度：O( 1 )

空间复杂度：O( n )

执行用时：7 ms

内存消耗：39.6 MB

## 方法二：链表 - 带头结点

**代码实现**

```java
class Node {
    int data;
    int min;
    Node next;
    Node(){}
}
class MinStack {
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
        head = new Node(); // 头结点
    }
    
    public void push(int val) {
        // 头插法
        Node node = new Node();
        node.data = val;
        node.next = head.next;
        if (head.next==null) node.min = val;
        else node.min = Math.min(val, head.next.min);

        head.next = node;
    }
    
    public void pop() {
        head.next = head.next.next;
    }
    
    public int top() {
        return head.next.data;
    }
    
    public int getMin() {
        return head.next.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

时间复杂度：O( 1 )

空间复杂度：O( n )

执行用时：7 ms

内存消耗：40.1 MB

## 方法三：链表 - 带头结点

**代码实现**

```java
class Node {
    int data;
    int min;
    Node next;
    Node(){}
}
class MinStack {
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        Node node = new Node();
        node.data = val;
        node.next = head;
        if (head==null) node.min = val;
        else node.min = Math.min(val, head.min);

        head = node;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

时间复杂度：O( 1 )

空间复杂度：O( n )

执行用时：5 ms

内存消耗：40.1 MB


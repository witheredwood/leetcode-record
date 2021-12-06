package com.withered.util;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> stack = new LinkedList<T>();

    /**
     * 向栈中压入一个元素
     *
     * @param entity 放入栈中的元素
     */
    public void push(T entity) {
        stack.addFirst(entity);
    }

    /**
     * 获取栈顶元素
     *
     * @return 栈顶
     */
    public T peek() {
        return stack.getFirst();
    }

    /**
     * 弹出栈顶
     *
     * @return 移除栈顶，并返回删除的栈顶
     */
    public T pop() {
        return stack.removeFirst();
    }

    /**
     * 栈是否为空
     *
     * @return true - 栈为空；false - 栈不为空
     */
    public boolean empty() {
        return stack.size() == 0;
    }

    /**
     * 将栈转为字符串
     *
     * @return 栈的字符串形式
     */
    public String toString() {
        return stack.toString();
    }
}

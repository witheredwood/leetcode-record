# 【Leetcode之栈/队列】0150 逆波兰表达式求值

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation

实现语言：Java

@[TOC](目录)

##  题目

根据[ 逆波兰表示法](https://baike.baidu.com/item/逆波兰式/128437)，求表达式的值。

有效的算符包括 `+`、`-`、`*`、`/` 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

**说明：**

- 整数除法只保留整数部分。
- 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

**示例**

```
输入：tokens = ["2","1","+","3","*"]
输出：9
解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

输入：tokens = ["4","13","5","/","+"]
输出：6
解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6

输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
输出：22
解释：
该算式转化为常见的中缀算术表达式为：
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```

## 方法：

**逆波兰表达式**：

逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。

- 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
- 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。

逆波兰表达式主要有以下两个优点：

- 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
- 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。

**代码实现**

```java
class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        int[] stack = new int[len]; int top = -1;
        int a=0, b=0;
        for (int i=0; i<len; i++) {
            if (tokens[i].equals("+")) {
                b = stack[top--];
                a = stack[top--];
                stack[++top] = a + b;
                continue;
            }
            if (tokens[i].equals("-")) {
                b = stack[top--];
                a = stack[top--];
                stack[++top] = a - b;
                continue;
            }
            if (tokens[i].equals("*")) {
                b = stack[top--];
                a = stack[top--];
                stack[++top] = a * b;
                continue;
            }
            if (tokens[i].equals("/")) {
                b = stack[top--];
                a = stack[top--];
                stack[++top] = a / b;
                continue;
            }
            // 把数字入栈
            stack[++top] = Integer.parseInt(tokens[i]);
        }

        return stack[top];
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：4 ms

内存消耗：38.2 MB


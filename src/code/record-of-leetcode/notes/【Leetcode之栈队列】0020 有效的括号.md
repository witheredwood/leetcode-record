# 【Leetcode之栈/队列】0020 有效的括号

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/valid-parentheses

实现语言：Java

@[TOC](目录)

##  题目

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

- 左括号必须用相同类型的右括号闭合。
- 左括号必须以正确的顺序闭合。

**示例**

```
输入：s = "()"
输出：true

输入：s = "()[]{}"
输出：true

输入：s = "(]"
输出：false

输入：s = "([)]"
输出：false

输入：s = "{[]}"
输出：true
```

- `s` 仅由括号 `'()[]{}'` 组成

## 方法：

**代码实现**

```java
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i=0; i<s.length(); i++) {
            // 当前字符是左括号
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
                stack[++top] = s.charAt(i);
                continue;
            }
            // 当前字符是右括号
            if (top==-1) return false;
            if (s.charAt(i)==')' && stack[top]!='(') return false;
            if (s.charAt(i)=='}' && stack[top]!='{') return false;
            if (s.charAt(i)==']' && stack[top]!='[') return false;
            top--;
        }
        if (top==-1)    return true;
        return false;
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：1 ms

内存消耗：36.5 MB


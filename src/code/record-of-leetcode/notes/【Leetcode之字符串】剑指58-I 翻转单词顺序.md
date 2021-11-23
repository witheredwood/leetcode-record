# 【Leetcode之字符串】剑指 Offer 58-I 翻转单词顺序

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof

实现语言：Java

@[TOC](目录)

##  题目

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

**示例**

```
输入: "the sky is blue"
输出: "blue is sky the"

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
```

## 方法一：分割+遍历

**代码实现**

```java
class Solution {
    public String reverseWords(String s) {
        // 删除多余的空格。" {1,}" 正则表达式，至少匹配一个空格 
        s = s.trim();  // 删除首尾空格
        String[] str = s.split(" {1,}");
        String res = "";
        // 逐一翻转单个单词
        for (int i=str.length-1; i>=0; i--) {
            res += str[i];
            if (i!=0) res += " ";
        }   
        return res;
    }
}
```

时间复杂度：O(n)	

空间复杂度：O(n)

执行用时：18 ms

内存消耗：39.3 MB

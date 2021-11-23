# 【Leetcode之字符串】0459 重复的子字符串

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/repeated-substring-pattern

实现语言：Java

@[TOC](目录)

##  题目

给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

**示例**

```
输入: "abab"
输出: True
解释: 可由子字符串 "ab" 重复两次构成。

输入: "aba"
输出: False

输入: "abcabcabcabc"
输出: True
解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
```



## 方法：

**代码实现**

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // 重新构造字符串
        String t = s + s;
        // 去掉新字符串t的第一个和最后一个字符
        int index = t.indexOf(s, 1);
        // 查找到的子串不是添加的子串s
        if (index!=s.length())  return true;
        // if (index==s.length())   查找到的子串是添加的子串s  
        return false;
    }
}
```

执行用时：105 ms

内存消耗：38.9 MB


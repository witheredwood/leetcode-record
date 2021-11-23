# 【Leetcode之字符串】剑指 Offer 58-II 左旋转字符串

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof

实现语言：Java

@[TOC](目录)

##  题目

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

**示例**

```
输入: s = "abcdefg", k = 2
输出: "cdefgab"

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
```

## 方法一：遍历

**代码实现**

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        String one = "";
        String res = "";
        for (int i=0; i<n; i++) {
            one += s.charAt(i);
        }
        for (int i=n; i<s.length(); i++) {
            res += s.charAt(i);
        }
        res += one;
        return res;
    }
}
```

时间复杂度：O(n)	

空间复杂度：O(1)

执行用时：54 ms

内存消耗：39.3 MB

## 方法二：使用内置函数

**代码实现**

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        String res = s.substring(n,s.length()) + s.substring(0,n);
        return res;
    }
}
```

时间复杂度：O(n)	

空间复杂度：O(n)

执行用时：0 ms

内存消耗：38.2 MB




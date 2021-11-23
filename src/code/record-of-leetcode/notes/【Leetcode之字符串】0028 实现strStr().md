# 【Leetcode之字符串】0028 实现strStr()

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/implement-strstr

实现语言：Java

@[TOC](目录)

##  题目

实现 `strStr()` 函数。

给定一个 `haystack` 字符串和一个 `needle` 字符串，在 `haystack` 字符串中找出 `needle` 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

**示例**

```
输入: haystack = "hello", needle = "ll"
输出: 2

输入: haystack = "aaaaa", needle = "bba"
输出: -1
```

说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

## 方法：KMP

1. `next()` 数组，找最大公共前后缀的长度

- `next[0] = -1`
- 当前子串的前缀和后缀相等时的长度 `len`，`next[j]=len`。长度 `len` 要从当前字串的最大长度 `j-1` 开始查找。 

2. KMP算法

- 整个匹配过程中，主串指针 `i` 始终没有回退，模式串指针 `j` 
- 当前字符匹配成功，主串指针 `i` 向后走一个，模式串指针 `j` 向后走一个

- 当前字符匹配失败时，移动模式串指针 `j`，`j = next[j]`
  - 如果指针 `j = -1` 时，修改指针 `j` 为0，主串指针 `i` 向后走一个
  - 否则，主串指针 `i` 不动

**代码实现**

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()==0 ) return 0;
        if (haystack.length()==0) return -1;

        int[] next = new int[needle.length()];
        next = getNext(needle);
        int i=0,j=0;
        for (;i<haystack.length() && j<needle.length(); ) {
            if (haystack.charAt(i)==needle.charAt(j)) {
                i++;   j++;
                continue;
            }
            j = next[j];
            if (j==-1){ j=0;    i++; }
        }
        if (j==needle.length()) return i-needle.length();
        return -1;
    }
    // 求解 next() 数组，模式串至少有一个字符
    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        
        for (int j=1; j<s.length();j++) {
            int len=j-1; // 当前子串的最长公共前后缀的长度
            // 查找当前子串的最长公共前后缀的长度
            while (len<j) {
                String prefix = s.substring(0,len);
                String suffix = s.substring(j-len,j);
                if (!prefix.equals(suffix)){
                    len--;
                } 
                if (prefix.equals(suffix)) {
                    break;
                }
            }
            next[j] = len;
        }
        return next;
    }
}
```

时间复杂度：O( n+m )

空间复杂度：O( m )

执行用时：1286 ms

内存消耗：39.7 MB


# 【Leetcode之字符串】0844 比较含退格的字符串

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/backspace-string-compare

实现语言：Java

@[TOC](目录)

##  题目

给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。

**示例**

```
输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。

输入：S = "ab##", T = "c#d#"
输出：true
解释：S 和 T 都会变成 “”。

输入：S = "a##c", T = "#a#c"
输出：true
解释：S 和 T 都会变成 “c”。

输入：S = "a#c", T = "b"
输出：false
解释：S 会变成 “c”，但 T 仍然是 “b”。
```

## 方法一：重构字符串

**代码实现**

```java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        String c1 = getFinalString(S);
        String c2 = getFinalString(T);
        if (c1.length() != c2.length()) return false;
        // 比较两个字符串是否相等
        for (int i=0; i<c1.length(); i++) {
            if (c1.charAt(i)!=c2.charAt(i))   return false;
        }
        return true;
    }
	// 求出两个字符串除去退格后最终的字符串
    public String getFinalString(String s) {
        char[] c = s.toCharArray();
        int len = 0; // 最终字符串的长度
        int j = 0;
        // 跳过字符串开头的#
        while (c[j]=='#') j++;
        while (j<c.length) {
            if (c[j]!='#') {
                c[len++] = c[j++];
            }
            else {
                if (len<=0) len = 0;
                else len--;
                j++;    
            }
        }
        s = "";
        for (int i=0; i<len; i++)    s += c[i];
        return s;
    }
}
```

时间复杂度：O(n+m)	

空间复杂度：O(n+m)

执行用时：10 ms

内存消耗：39.1 MB

## 方法二：栈

**代码实现**

```java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] c1 = new char[S.length()];
        char[] c2 = new char[T.length()];
       int top1=0,top2=0;
        for (int j=0; j<S.length(); j++) {
            if (S.charAt(j)!='#'){
                c1[top1++] = S.charAt(j);
            } 
            else {
                if (top1>0) top1--;
            }
        }       
        for (int j=0; j<T.length(); j++) {
            if (T.charAt(j)!='#') c2[top2++] = T.charAt(j);
            else {
                if (top2>0) top2--;
            }
        }
        if (top1!=top2) return false;
        while (top1!=0 && top2!=0) {
            if (c1[--top1] != c2[--top2]) return false;
        }
        if (top1!=0 || top2!=0) return false;
        return true;
    }
}
```

时间复杂度：O(n+m)  遍历两个字符串

空间复杂度：O(n+m)  两个栈

执行用时：1 ms

内存消耗：36.7 MB






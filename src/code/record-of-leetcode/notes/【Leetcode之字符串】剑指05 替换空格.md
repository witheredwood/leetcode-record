# 【Leetcode之字符串】剑指05 替换空格

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

实现语言：Java

@[TOC](目录)

##  题目

请实现一个函数，把字符串 `s` 中的每个空格替换成"%20"。

**示例**

```
输入：s = "We are happy."
输出："We%20are%20happy."
```

## 方法一：调用内置函数

**代码实现**

```java
class Solution {
    public String replaceSpace(String s) {
        s = s.replace(" ","%20");
        return s;
    }
}
```

时间复杂度：O(n)	

空间复杂度：O(n)

执行用时：0 ms

内存消耗：36.4 MB

## 方法二：遍历

**代码实现**

```java
class Solution {
    public String replaceSpace(String s) {
        String str = "";
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!=' ')   str += Character.toString(s.charAt(i));
            else str += "%20";
        }         
        return str;
    }
}
```

时间复杂度：O(n)	

空间复杂度：O(1)

执行用时：1 ms

内存消耗：38.2 MB

## 方法三：字符数组

**代码实现**

```java
class Solution {
    public String replaceSpace(String s) {
        //String str = "";
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==' ')   count++;
        }         
        char[] c = new char[s.length()+2*count];
        // 从后向前遍历，修改空格
        for (int i=c.length-1,j=s.length()-1; j>=0; j--) {
            if (s.charAt(j)!=' ')   c[i--] = s.charAt(j);
            else {
                c[i] = '0';
                c[i-1] = '2';
                c[i-2] = '%';
                i -= 3;
            }
        } 

        return new String(c);
    }
}
```

时间复杂度：O(n)	

空间复杂度：O(n)

执行用时：0 ms

内存消耗：36.5 MB
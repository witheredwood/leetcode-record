# 【Leetcode之字符串】0541 反转字符串 II

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/reverse-string-ii

实现语言：Java



##  题目

给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

**示例**

```
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
```

## 方法：

**代码实现**

```java
class Solution {
    public String reverseStr(String s, int k) {
        int left = 0;
        int len = s.length();
        while (len >= 2*k) {
            s = reverse(s, left, k); 
            left += 2*k;            
            len -= 2*k;          
        }
        if (len >= k)   s = reverse(s, left, k);  
        else    s = reverse(s, left, len);            
        return s;
    }
    // 反转字符串s中[left, left+range)的字符
    public String reverse(String s, int left, int range) {
        char[] c = s.toCharArray();
        char tmp;
        for (int i=left,j=left+range-1; i<j; i++,j--) {
            tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        return new String(c);
    }
}
```

时间复杂度：O(n)	

空间复杂度：O(n)

执行用时：10 ms

内存消耗：39.1 MB


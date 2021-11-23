# 【Leetcode之字符串】0925 长按键入

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/long-pressed-name

实现语言：Java

@[TOC](目录)

##  题目

你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

**示例**

```
输入：name = "alex", typed = "aaleex"
输出：true
解释：'alex' 中的 'a' 和 'e' 被长按。

输入：name = "saeed", typed = "ssaaedd"
输出：false
解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。

输入：name = "leelee", typed = "lleeelee"
输出：true

输入：name = "laiden", typed = "laiden"
输出：true
解释：长按名字中的字符并不是必要的。
```

## 方法：遍历

**代码实现**

```java
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int len1 = name.length(), len2 = typed.length();
        // 比较两个字符串第一个字符是否相等
        if (name.charAt(i) != typed.charAt(j)) return false;
        i++;    j++;
        // 遍历。逐一比较
        while (i<len1 && j<len2) {
            if (name.charAt(i) == typed.charAt(j)){
                i++;    j++;
                continue;
            }
            // j>=1
            if (typed.charAt(j) == typed.charAt(j-1)) j++;
            else return false;
        }       
        // 查看typed最后的字符串应该相等，若不相等，则有非长按的字符
        while (j<len2) {
            if (typed.charAt(j) != typed.charAt(j-1))   return false;
            j++;
        }
        if (i==len1)    return true;
        return false;
    }
}
```

时间复杂度：O(n+m)	

空间复杂度：O(1)

执行用时：1 ms

内存消耗：36.6 MB


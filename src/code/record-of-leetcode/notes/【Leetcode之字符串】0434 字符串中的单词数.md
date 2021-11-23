# 【Leetcode之字符串】0434 字符串中的单词数

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string/

实现语言：Java



##  题目

统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

请注意，你可以假定字符串里不包括任何不可打印的字符。

**示例**

```
输入: "Hello, my name is John"
输出: 5
解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
```

## 方法：

**代码实现**

```java
class Solution {
    public int countSegments(String s) {
        // 去除首尾空格
        s = s.trim();
        if (s.length()==0) return 0;
        String[] str = s.split(" {1,}");
        return str.length;
    }
}
```

时间复杂度：O(n)	split()时间复杂度是O(n)

空间复杂度：O(n)	split()返回O(n)的数组，使用额外的空间

执行用时：3 ms

内存消耗：36.4 MB


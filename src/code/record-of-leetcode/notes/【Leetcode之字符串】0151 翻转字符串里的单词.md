# 【Leetcode之字符串】0151 翻转字符串里的单词

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/reverse-words-in-a-string

实现语言：Java



##  题目

给定一个字符串，逐个翻转字符串中的每个单词。

说明：

- 无空格字符构成一个 单词 。
- 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
- 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

**示例**

```
输入："the sky is blue"
输出："blue is sky the"

输入："  hello world!  "
输出："world! hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

输入："a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

输入：s = "  Bob    Loves  Alice   "
输出："Alice Loves Bob"

输入：s = "Alice does not even like bob"
输出："bob like even not does Alice"
```

**提示：**

1. `1 <= S.length <= 20000`
2. `S` 仅由小写英文字母组成。

## 方法：两次翻转

**代码实现**

```java
class Solution {
    public String reverseWords(String s) {
        // 删除多余的空格。" {1,}" 正则表达式，至少匹配一个空格 
        s = s.trim();  // 删除首尾空格
        String[] str = s.split(" {1,}");
        String res = "";
        // 逐一翻转单个单词
        for (int i=0; i<str.length; i++) {
            str[i] = reverseOneWord(str[i]);
            res += str[i];
            if (i!=str.length-1) res += " ";
        }
        // 翻转全部字符串
        res = reverseOneWord(res);     
        return res;
    }
    // 翻转一个单词
    public static String reverseOneWord(String s) {
		char[] str = s.toCharArray();
        char tmp;
        for (int i=0,j=str.length-1; i<j; i++,j--) {
            tmp = str[j];
            str[j] = str[i];
            str[i] = tmp;
        }
        return new String(str);
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：17 ms

内存消耗：39.3 MB


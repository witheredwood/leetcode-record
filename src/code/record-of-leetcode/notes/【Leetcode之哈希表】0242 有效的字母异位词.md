# 【Leetcode之哈希表】0242 有效的字母异位词

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/contains-duplicate-ii

实现语言：Java



##  题目

给定两个字符串 *s* 和 *t* ，编写一个函数来判断 *t* 是否是 *s* 的字母异位词。

**示例**

```
输入: s = "anagram", t = "nagaram"
输出: true

输入: s = "rat", t = "car"
输出: false
```

- **说明:**
  你可以假设字符串只包含小写字母。

  **进阶:**
  如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

## 方法：数组

字母异位词是指由相同的字母按照不同的顺序组成的单词。

采用的判断方法：每个字母出现的次数相同。

**代码实现**

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] table1 = new int[26];
        int[] table2 = new int[26];
        table1 = countNumbers(s);
        table2 = countNumbers(t);
        for (int i=0; i<26; i++) {
            if (table1[i] != table2[i]) return false;
        }
        return true;
    }
    // calculate the numbers of all characters
    public int[] countNumbers(String s) {
        int[] table = new int[26];
        for (int i=0; i<26; i++) {
            table[i] = 0;
        }
        for (int i=0; i<s.length(); i++) {
            table[s.charAt(i)-'a']++;
        }
        return table;
    }
}
```

时间复杂度：O( max(n, 26) )

空间复杂度：O( 52 )

执行用时：4 ms

内存消耗：38.6 MB


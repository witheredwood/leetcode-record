# 【Leetcode之链表】0205 同构字符串

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/isomorphic-strings/

实现语言：Java



##  题目

给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

**示例**

```
输入：s = "egg", t = "add"
输出：true

输入：s = "foo", t = "bar"
输出：false

输入：s = "paper", t = "title"
输出：true
```

**提示：**

- 可以假设 ***s*** 和 ***t*** 长度相同。

## 方法：哈希表

**代码实现**

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hash = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            // 哈希表中已有该字符的映射
            if (hash.containsKey(c)) {
                if (hash.get(c).equals(d)) continue;
                return false;
            }  
            if (!hash.containsKey(c)) {
                if (hash.containsValue(d)) return false;
                hash.put(c, d);
            }
        }
        return true;
    }
}
```

空间复杂度：O(n)

执行用时：13 ms

内存消耗：38.5 MB


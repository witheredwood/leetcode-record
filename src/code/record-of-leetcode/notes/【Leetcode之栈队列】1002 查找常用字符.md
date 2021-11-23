# 【Leetcode之栈/队列】1002 查找常用字符

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/find-common-characters

实现语言：Java

@[TOC](目录)

##  题目

给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

**示例**

```
输入：["bella","label","roller"]
输出：["e","l","l"]

输入：["cool","lock","cook"]
输出：["c","o"]
```

## 方法：计数

**代码实现**

```java
class Solution {
    public List<String> commonChars(String[] A) {
        int[] res = new int[26];
       
        int len = A.length;
        // 把第一个字符串中各字符的数量，存入数组中
        for (int i=0; i<A[0].length(); i++) {	
            res[A[0].charAt(i)-'a']++;
        }
        for (int i=1; i<len; i++) { // O(n)
            // 每个字符串都需要用到tmp数组，所以每次都要初始化为0
            int[] tmp = new int[26];
            // 计算剩余的每个字符串中各字符的数量，存入数组中
            for (int k=0; k<A[i].length(); k++) { // O(m)
                tmp[A[i].charAt(k)-'a']++;
            }

            // 找公共字符
            for (int j=0; j<26; j++) {	// O(26)
                res[j] = Math.min(res[j], tmp[j]);
            }
        }
        List<String> result = new ArrayList<String>();
        for (int i=0; i<26; i++) {
            if( res[i]<=0) continue;
            for (int j=0; j<res[i]; j++)
                result.add(Character.toString('a'+i));
        }
        return result;
    }
}
```

时间复杂度：O( n(m+26) )

空间复杂度：O( 26 )

执行用时：3 ms

内存消耗：38.8 MB


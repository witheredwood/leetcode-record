# 【Leetcode之哈希表】1047 删除字符串中的所有相邻重复项

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string

实现语言：Java



##  题目

给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

**示例**

```
输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

**提示：**

1. `1 <= S.length <= 20000`
2. `S` 仅由小写英文字母组成。

## 方法一：递归

若`remove()` 函数不返回字符串，则`removeDuplicates()` 无法获得删除重复后的字符串

**代码实现**

```java
class Solution {
    public String removeDuplicates(String S) {
        boolean flag = false; // 是否修改了字符串
        S =  remove(S);
        return S;
    }
    public String remove(String S) {
        boolean flag = false; // 是否修改了字符串
        for (int i=0; i<S.length()-1; i++) {
            if (S.charAt(i) == (S.charAt(i+1))) {
                S = S.substring(0, i) + S.substring(i+2, S.length());
                flag = true;
            }
        }
        if (flag) S = remove(S);
        return S;
    }
}
```

执行用时：48 ms

内存消耗：39.1 MB

## 方法二：栈

只需遍历一遍字符串，字符串遍历完成后，栈里的字符就是最终的结果。

**代码实现**

```java
import java.util.Arrays;
class Solution {
    public String removeDuplicates(String S) {
        char[] c = S.toCharArray();
        char[] stack = new char[S.length()];
        int top = -1;     
        for (int i=0; i<c.length; i++) {
            if (top == -1) { // stack is empty
                stack[++top] = c[i];
                continue;
            }
            if (stack[top]!=c[i]) {
                stack[++top] = c[i];
                continue;
            }
            top--;
        }
        stack = Arrays.copyOfRange(stack,0,top+1);
        return new String(stack);
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：5 ms

内存消耗：39.2 MB




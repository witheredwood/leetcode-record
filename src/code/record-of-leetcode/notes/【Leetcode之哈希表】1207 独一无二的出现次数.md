# 【Leetcode之哈希表】1207 独一无二的出现次数

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/unique-number-of-occurrences

实现语言：Java



##  题目

给你一个整数数组 `arr`，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 `true`；否则返回 `false`。

**示例**

```
输入：arr = [1,2,2,1,1,3]
输出：true
解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。

输入：arr = [1,2]
输出：false

输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
输出：true
```

**提示：**

- `1 <= arr.length <= 1000`
- `-1000 <= arr[i] <= 1000`

## 方法：哈希表

在检查哈希表中某一`key`的`value`是否是唯一的时，不能删除该条键值对，可以修改值`value`为哈希表中没有出现过的值。

**代码实现**

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                count++;
                map.replace(arr[i], count);
                continue;
            }
            map.put(arr[i], 1);
        }
        for (int key: map.keySet()) {
            int value = map.get(key);
            map.replace(key, -1);
            if (map.containsValue(value))  return false;
        }
        return true;
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：2 ms

内存消耗：36.5 MB


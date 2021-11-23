# 【Leetcode之哈希表】0219 存在重复元素II

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/contains-duplicate-ii

实现语言：Java



##  题目

给定一个整数数组和一个整数 `k`，判断数组中是否存在两个不同的索引 `i` 和 `j`，使得 `nums [i] = nums [j]`，并且 `i` 和 `j` 的差的 绝对值 至多为 `k`。

**示例**

```
输入: nums = [1,2,3,1], k = 3
输出: true

输入: nums = [1,0,1,1], k = 1
输出: true

输入: nums = [1,2,3,1,2,3], k = 2
输出: false
```

## 方法：哈希表

哈希表结构为：`{nums[i], index}`

把数组中的数逐一添加到哈希表中，在添加时，判断哈希表中是否已经存在相同的值。如果存在，两者的下标`index`相差在k以下，即符合条件

**代码实现**

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        // nums为Key，下标为Value
        for (int i=0; i<nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                if (i-hash.get(nums[i]) <= k)   return true;
                // update the index of current value
                hash.replace(nums[i],i);    
                continue;
            }
            hash.put(nums[i], i);
        }
         return false;
    }
}
```

时间复杂度：O(n)

空间复杂度：O( min(n,k) )

执行用时：8 ms

内存消耗：43.9 MB


# 【Leetcode之哈希表】0349 两个数组的交集

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/

实现语言：Java



##  题目

给定两个数组，编写一个函数来计算它们的交集。

**示例**

```
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
```

- **说明：**
  - 输出结果中的每个元素一定是唯一的。
- 我们可以不考虑输出结果的顺序。

## 方法：数组

字母异位词是指由相同的字母按照不同的顺序组成的单词。

采用的判断方法：每个字母出现的次数相同。

**代码实现**

```java
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length==0 || nums2.length==0) return new int[]{};
        // creat a hash table of nums1
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i=0,j=0; i<nums1.length; i++) {  // O(n)
            if (!hash.containsKey(nums1[i])){
                hash.put(nums1[i], j++);
            }
        }
        int[] result = new int[nums2.length];
        int len = 0;
        for (int i=0; i<nums2.length; i++) {	// O(m)
            if (hash.containsKey(nums2[i])) { 	// O(1)              
                result[len++] = nums2[i];
                hash.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(result, 0, len);
    }
}
```

时间复杂度：O( max(n,m) )

空间复杂度：O( n )

执行用时：3 ms

内存消耗：38.6 MB


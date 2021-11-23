# 【Leetcode之哈希表】0350 两个数组的交集 II

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/

实现语言：Java



##  题目

给定两个数组，编写一个函数来计算它们的交集。

**示例**

```
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
```

- **说明：**
  - 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
  - 我们可以不考虑输出结果的顺序。

## 方法：数组

字母异位词是指由相同的字母按照不同的顺序组成的单词。

采用的判断方法：每个字母出现的次数相同。

**代码实现**

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length==0 || nums2.length==0) return new int[]{};
        
        Map<Integer, Integer> hash1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> hash2 = new HashMap<Integer, Integer>();
        hash1 = countNumbers(nums1); // O(n)
        hash2 = countNumbers(nums2); // O(m)

        int[] result = new int[nums2.length];
        int len = 0;
        for (int key: hash2.keySet()) {	// O(m)
            if (!hash1.containsKey(key)) continue;             
            int min = hash1.get(key)>hash2.get(key)? hash2.get(key): hash1.get(key);
            for (int j=0; j<min; j++) {
                result[len++] = key;
            }
        }
        return Arrays.copyOfRange(result, 0, len);
    }
    // count the number of occurrences of each number
    public Map countNumbers(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i=0,j=0; i<nums.length; i++) {  // O(n)
            if (!hash.containsKey(nums[i])){
                hash.put(nums[i], 0);
            }
            // update counts
            int count = hash.get(nums[i]);
            count++;
            hash.replace(nums[i], count);
        }
        return hash;
    }
}
```

时间复杂度：O( n+m )	需要遍历两个哈希表

空间复杂度：O( min(m,n) )

执行用时：6 ms

内存消耗：38.3MB


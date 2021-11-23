# 【Leetcode之数组】0001 两数之和

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/two-sum/

实现语言：Java



##  题目

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

**示例**

```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

输入：nums = [3,2,4], target = 6
输出：[1,2]

输入：nums = [3,3], target = 6
输出：[0,1]
```

**注意**：

- 数组中的值包含0和负数

## 方法一：暴力法

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            int res = target - nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (res == nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    } 
            }      
        }
        return result;
    }
}
```

时间复杂度：O(n^2)		

空间复杂度：O(1)

执行用时：0 ms

内存消耗：38.8 MB

## 方法二：哈希法

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表。数组的值为索引key，数组的下标为值value
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            // 如果哈希表中包含所要找的差值target-nums[i]，就返回下标
             if ( hash.containsKey(target - nums[i])) {  
                int index = hash.get(target - nums[i]);
                if (i != index)     return new int[]{i, index};  
                break;
            }
            // 在哈希表中没有找到相应的差值target-nums[i]，添加nums[i]
            hash.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
```

时间复杂度：O(n)		

空间复杂度：O(n)

执行用时：0 ms

内存消耗：38.7 MB


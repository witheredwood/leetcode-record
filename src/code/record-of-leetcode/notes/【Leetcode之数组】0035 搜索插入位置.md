# 【Leetcode之数组】0035 搜索插入位置

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/search-insert-position

实现语言：Java



##  题目

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

**示例**

```
输入: [1,3,5,6], 5
输出: 2

输入: [1,3,5,6], 2
输出: 1

输入: [1,3,5,6], 0
输出: 0
```

## 方法一：暴力法

**代码实现**

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        // traverse the array
        for (int i=0; i<nums.length; i++) {         
            // found
            if (nums[i]==target) return i;
            if (nums[i]<target) continue;           
            if (nums[i]>target) return i;
        }
        return nums.length;
    }
}
```

时间复杂度：O(n)		

空间复杂度：O(1)

执行用时：0 ms

内存消耗：37.9 MB

## 方法二：二分法

**代码实现**

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid, left=0,right=nums.length-1;
        while (left<=right) {
            mid = (left+right)/2;
            // find the target
            if (target==nums[mid]) return mid;

            if (target<nums[mid]) {
                right = mid - 1;
                continue;
            }
            if (target>nums[mid]) {
                left = mid + 1;
                continue;
            }
        }
        // not find the target
        return left;
    }
}
```

执行用时：0 ms

内存消耗：38.2 MB
# 【Leetcode之数组】0034 在排序数组中查找元素的第一个和最后一个位置

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array

实现语言：Java

##  题目

给定一个按照升序排列的整数数组 `nums`，和一个目标值 `target`。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 `target`，返回 `[-1, -1]`。

**示例**

```
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

输入：nums = [], target = 0
输出：[-1,-1]
```

## 方法一：暴力法

**代码实现**

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {         
        int left=-1, right=-1;  // the left and right index of the finall array
        // traverse the array
        for (int i=0; i<nums.length; i++) {
            if (nums[i]<target) continue;
            if (nums[i]>target) break;
            // nums[i] == target
            if (left==-1) {
                left = i;
                right = i;
            } else {
                right = i;
            }     
        }
        return new int[]{left, right};
    }
}
```

时间复杂度：O(n)		

空间复杂度：O(1)

执行用时：1 ms

内存消耗：41.7 MB

## 方法二：二分法

**代码实现**

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=-1, right=-1;  // the left and right index of the finall array
        // 
        int mid;
        for (int i=0,j=nums.length-1; i<=j; ) {
            mid = (i+j)/2;
            if (nums[mid]<target){
                i = mid+1;
                continue;
            }   
            if (nums[mid]>target){
                j = mid-1;
                continue;
            }  
            // find the first target
            left = mid;
            right = mid;
            break;
        }
        if (left==-1) return new int[]{-1,-1};
        // find the outher target 
        for (int i=left; i>=0 && nums[i]==nums[left]; i--) left=i;
        for (int j=right; j<nums.length && nums[j]==nums[right]; j++) right=j;

        return new int[]{left, right};
    }
}
```

执行用时：0 ms

内存消耗：41.7MB
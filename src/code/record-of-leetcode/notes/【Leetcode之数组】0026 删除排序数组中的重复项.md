# 【Leetcode之数组】0026 删除排序数组中的重复项

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array

实现语言：Java



##  题目

给定一个排序数组，你需要在 **原地** 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 **原地** 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

**示例**

```
给定数组 nums = [1,1,2], 
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
你不需要考虑数组中超出新长度后面的元素。

给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。
```

**说明:**

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以**「引用」**方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

## 方法：快慢指针法

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0; // the index of the last element of the finall array
        // traverse the original array
        for (int i=1; i<nums.length; i++) {
            if (nums[index] == nums[i]) continue;
			// nums[index] != nums[i]
            index++;
            nums[index] = nums[i];  
        }
        return index+1;
    }
}
```

时间复杂度：O(n)		

空间复杂度：O(1)

执行用时：0 ms

内存消耗：40.3 MB

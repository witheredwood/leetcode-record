# 【Leetcode之数组】0031 下一个排列

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/next-permutation

实现语言：Java



##  题目

实现获取 **下一个排列** 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 **原地** 修改，只允许使用额外常数空间。

**示例**

```
输入：nums = [1,2,3]
输出：[1,3,2]

输入：nums = [3,2,1]
输出：[1,2,3]
```

## 方法

字典序是基于字母顺序排列的单词按字母顺序排列的方法。

对于数字1、2、3......n的排列，不同排列的先后关系是从左到右逐个比较对应的数字的先后来决定的。例如对于5个数字的排列 12354和12345，排列12345在前，排列12354在后。全排列{1,2,3} 按照字典序的下一个排列分别是 123、132、213、231、312 和 321。

**按照字典序找下一个排列的过程**

假设有一个数组`array=[a0, a1, a2, ..., an]`，下标为`0 - n`

**Step1** 

从右向左，找到第一个比右边数小的数的下标 `index`

**Step2**  

从 `index` 到 `n` ，找到比 `array[index]` 大的所有数中的最小值，最小值的下标为 `min`

**Step3** 

对换 `array[index]` 和 `array[min]`

**Step4** 

翻转 `array[index+1]` 到 `array[n]` 之间的所有数

**Step5** 

如果没有找到 `index` ，也就是，数组倒序排列，则翻转整个数组

**代码实现**

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        int index;
        boolean flag = false; // whether to find the next permutation
        for (index=len-2; index>=0 && !flag; index--) {
           if (nums[index]<nums[index+1]) {              
                // find the miniumn value which is greater than nums[index]
                int min = len-1;
                while (min>index && nums[min]<=nums[index]) min--;
                // swap nums[index] and nums[min] 
                int tmp = nums[min];
                nums[min] = nums[index];
                nums[index] = tmp;
                // reverse elements after nums[index]
                reversal(nums,index+1,len-1);
                flag = true;
           }
       }
       // if not find the next permutatino, reverse the array
       if (!flag) reversal(nums,0,len-1);
    }
    // reverse the array from left to right
    public void reversal(int[] nums, int left, int right) {
        for (int i=left,j=right; i<j; i++,j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
```

时间复杂度：O(n)		

空间复杂度：O(1)

执行用时：1 ms

内存消耗：38.4 MB

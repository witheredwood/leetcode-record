# 【Leetcode之栈/队列】剑指59-I 滑动窗口得最大值.md

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof

实现语言：Java

@[TOC](目录)

##  题目

给定一个数组 `nums` 和滑动窗口的大小 `k`，请找出所有滑动窗口里的最大值。

**示例**

```
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

## 方法：暴力解法

**代码实现**

```java
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {        
        if (nums.length;==0) return new int[]{};
        
        int len = nums.length;
        int[] res = new int[len-k+1];        
        for (int i=0; i<len-k+1; i++) {
            int max = nums[i];
            for (int j=0; j<k; j++) { 
                if (nums[i+j]>max) max = nums[i+j];   
            }
            res[i] = max;
        }
        return res;
    }
}
```

时间复杂度：O( nk )

空间复杂度：O( n-k+1 )

执行用时：34 ms

内存消耗：46.4 MB

## 方法：单调双端队列

**代码实现**

```java
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {       
        if (nums.length==0) return new int[]{};

        int len = nums.length;
        int[] res = new int[len-k+1];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        // i是滑动窗口左端的下标，j是滑动窗口右端的下标
        // i=0之后，每入队一个元素，就输出一个最大值
        for (int i=1-k,j=0; j<len; i++,j++) {
            while (deque.size()>0 && deque.peek()<i) {
                deque.poll(); // 从队首删除不在窗口内的值
            }
            // 从队首删除所有比当前元素小的值
            while (deque.size()>0 && nums[deque.peek()]<nums[j]) { 
                deque.poll();
            }
            // 从队尾删除所有比当前元素小的值
            while (deque.size()>0 && nums[deque.peekLast()]<nums[j]) { 
                deque.pollLast();
            }
            deque.offer(j); // 新元素入队
            if (i>=0) res[i] = nums[deque.peek()]; //输出当前位置的最大值
        }
        return res;
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：14 ms

内存消耗：47.4 MB


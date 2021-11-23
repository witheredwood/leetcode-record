# 【Leetcode之栈/队列】0084 柱状图中最大的矩形

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/valid-parentheses

实现语言：Java

@[TOC](目录)

##  题目

给定 *n* 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

 ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram.png)

以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 `[2,1,5,6,2,3]`。

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram_area.png)

图中阴影部分为所能勾勒出的最大矩形面积，其面积为 `10` 个单位。

**示例**

```
输入: [2,1,5,6,2,3]
输出: 10
```



## 方法一：暴力解法

**代码实现**

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int len = heights.length;
        // 固定高度，找最大宽度
        for (int i=0; i<len; i++) {
            // 找到该高度下左边的边界，也就是左边小于该高度的值
            int j = i-1;
            while (j>=0 && heights[j]>=heights[i]) j--;
            // 找到该高度下右边的边界，也就是右边小于该高度的值
            int k = i+1;  
            while (k<len && heights[k]>=heights[i]) k++;
            int wid = k-j-1;
            max = Math.max(max,wid*heights[i]);
        }
        return max;
    }
}
```

时间复杂度：O( n^2 )

空间复杂度：O( 1 )

## 方法二：单调栈

**代码实现**

```java
class Solution {
    public int largestRectangleArea(int[] heights) {       
        int len = heights.length;
        if (len==0) return 0;
        int[] stack = new int[len];     int top = -1; // 栈里存放下标
        int max = 0;    int area = 0;
        // 固定高度，找最大宽度
        for (int i=0; i<len; ) {
            if (top==-1) {
                stack[++top] = i++;   // 入栈
                continue;
            }
            int index = stack[top]; //取出栈里的下标
            if ( heights[i]>=heights[index]) {
                stack[++top] = i++;   // 入栈
                continue;
            }
            if (heights[i]<heights[index]) {
                top--;  // 出栈
                // 新栈顶 
                if (top==-1) area = heights[index] * i;
                else  area = heights[index] * (i-stack[top]-1);
                max = Math.max(max,area);
            }
        }
        // 计算栈里剩余高度的面积
        while (top>-1) {
                int index = stack[top];
                top--;
                if (top==-1) area = heights[index] * len;
                else  area = heights[index] * (len-stack[top]-1);
                max = Math.max(max,area);
        }
        return max;
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：7 ms

内存消耗：47.3 MB






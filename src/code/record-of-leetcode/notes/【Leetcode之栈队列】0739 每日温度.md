# 【Leetcode之栈/队列】0739 每日温度

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/daily-temperatures

实现语言：Java

@[TOC](目录)

##  题目

请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 `temperatures = [73, 74, 75, 71, 69, 72, 76, 73]`，你的输出应该是 `[1, 1, 4, 2, 1, 1, 0, 0]`。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

## 方法一：数组

**代码实现**

```java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i=0; i<len; i++) {
            int count = 0;
            while (i+count<len && T[i+count]<=T[i])    count++;
            if (i+count == len) res[i] = 0;
            else res[i] = count;
        }
        return res;
    }
}
```

时间复杂度：O( n^2 )

空间复杂度：O( n )

执行用时：2199 ms

内存消耗：46.6 MB

## 方法二：单调栈

**代码实现**

```java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        int[] stack = new int[len]; int top = -1;
        for (int i=0; i<len; ) {
            if (top==-1){
                stack[++top] = i;
                i++;
                continue;
            }
            int index = stack[top];
            if (T[i]<=T[index]){
                stack[++top] = i;
                i++;
                continue;
            }
            if (T[i]>T[index]) {
                res[index] = i - index;
                top--;
            }
        }
        return res;
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：4 ms

内存消耗：45.6 MB




# 【Leetcode之栈/队列】0973 最接近原点的K个点

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/k-closest-points-to-origin

@[TOC](目录)

##  题目

我们有一个由平面上的点组成的列表 `points`。需要从中找出 `K` 个距离原点 `(0, 0)` 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

**示例：**

```
输入：points = [[1,3],[-2,2]], K = 1
输出：[[-2,2]]
解释： 
(1, 3) 和原点之间的距离为 sqrt(10)，
(-2, 2) 和原点之间的距离为 sqrt(8)，
由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。

输入：points = [[3,3],[5,-1],[-2,4]], K = 2
输出：[[3,3],[-2,4]]
（答案 [[-2,4],[3,3]] 也会被接受。）
```

## 方法：优先级队列 - 最大堆

普通的队列是一种先进先出的数据结构，元素在队列尾追加，而从队列头删除。在优先队列中，元素被赋予优先级。当访问元素时，具有最高优先级的元素最先删除。优先队列具有最高级先出 （first in, largest out）的行为特征。通常采用堆数据结构来实现。

如果不提供比较器 `Comparator`，优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，字符串则按字典序排列。比较器`Comparator`通过重写返回`int`值的正负来做判断。

比如：

```java
public int compare(int a, int b) {
   return b - a; //后面的元素-前面的元素
} 
```

- 结果为 `-`，则返回前面一个元素，也就是 a 的优先级比较高

- 结果为 `+`，则返回后面一个元素，也就是 b 的优先级比较高

  

```java
public int compare(int a, int b) {
   return a - b; //前面的元素-后面的元素
} 
```

- 结果为 `-`，则返回前面一个元素，也就是 a 的优先级比较高

- 结果为 `+`，则返回后面一个元素，也就是 b 的优先级比较高

  

优先级队列里存放每个点的 平方和 以及 下标。本题采用最大堆实现，也就是大值在队头，构造大小为k的最大堆，最顶为最大值。因此，前k个点的平方和以及下标可以直接放入优先级队列里。剩余的数据，如果平方和小于队头的平方和，才移除队头的数据，插入新数据。

**代码实现**

```java
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        // 构造优先级队列的比较器，返回的值必须是比较的结果，不能返回min(),max()之类的
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0]- a[0]; 
            }
        };
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(comparator);
        // 构造最大堆（堆顶为最大值），大小为k。前k个数据直接放入堆里
        for (int i=0; i<k; i++) {
            int sum = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            int[] tmp = new int[]{sum, i};
            queue.offer(tmp);
        }
        // 剩余的数据，判断是否加入到堆里。
        // 如果小于最大堆里的最大值，也就是堆顶的值，就加入到最大堆里，否则，不加入堆里
        for (int i=k; i<len; i++) {
            int sum = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            // peek()返回的是堆顶的数据
            if (sum<queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{sum,i});
            }
        }
        //  取出堆里的全部数据，放入到最终的结果中，并返回
        int[][] res = new int[k][2];
        for (int i=0; i<k; i++) {
            res[i] = points[queue.poll()[1]];
        }
        return res;
    }
}
```

时间复杂度：O( n )

空间复杂度：O( k )

执行用时：32 ms

内存消耗：46.4 MB


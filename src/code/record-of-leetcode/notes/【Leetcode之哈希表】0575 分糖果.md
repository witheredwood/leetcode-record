# 【Leetcode之哈希表】0575 分糖果

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/distribute-candies

实现语言：Java



##  题目

给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

**示例**

```
输入: candies = [1,1,2,2,3,3]
输出: 3
解析: 一共有三种种类的糖果，每一种都有两个。
     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。

输入: candies = [1,1,2,3]
输出: 2
解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
```

- **注意:**
  1. 数组的长度为[2, 10,000]，并且确定为偶数。
  2. 数组中数字的大小在范围[-100,000, 100,000]内。

## 方法：哈希集合

由于不需要计算各类糖果的数量，只需要知道有多少类糖果，所有使用`HashSet`实现。

**代码实现**

```java
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set= new HashSet<>();
        for (int i=0; i<candyType.length; i++) {
            if (!set.contains(candyType[i])) {
                set.add(candyType[i]);
            }
        }
        int num = candyType.length / 2;  
        return set.size()<num ? set.size():num;
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：42 ms

内存消耗：40.5 MB


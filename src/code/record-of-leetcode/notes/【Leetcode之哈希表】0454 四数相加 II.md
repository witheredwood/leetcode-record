# 【Leetcode之哈希表】454 四数相加 II

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/4sum-ii

实现语言：Java



##  题目

给定四个包含整数的数组列表 `A , B , C , D` ,计算有多少个元组 `(i, j, k, l)` ，使得 `A[i] + B[j] + C[k] + D[l] = 0`。

为了使问题简单化，所有的 `A, B, C, D` 具有相同的长度 `N`，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

**示例**

```
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
```

## 方法：分组+哈希表

`A[i] + B[j] + C[k] + D[l] = 0` 可转换为`A[i] + B[j] = -( C[k] + D[l] )`，分成两组分别计算`A[i] + B[j]` 和 `C[k] + D[l]` 的和，并存放在两个哈希表中。哈希表，结构为 { 和, 出现的次数 } 。

**代码实现**

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> h1 = new HashMap<>();
        Map<Integer, Integer> h2 = new HashMap<>();
        h1 = createHashMap(A, B);
        h2 = createHashMap(C, D);
        int result = 0;
        for (int key: h1.keySet()) {
            if(!h2.containsKey(-key))  continue;
            result += h1.get(key) * h2.get(-key);
        }
        return result;
    }
	// 创建哈希表，结构为{和, 出现的次数}
    public Map createHashMap(int[] A, int[] B) {
        Map<Integer, Integer> h1 = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<B.length; j++) {
                if (!h1.containsKey(A[i]+B[j])) {
                    h1.put(A[i]+B[j],1);
                    continue;
                }
                int count = h1.get(A[i]+B[j]);
                count++;
                h1.replace(A[i]+B[j], count);
            }      
        }
        return h1;
    }
}
```

时间复杂度：O( n^2 )

空间复杂度：O( n^2 )

执行用时：157 ms

内存消耗：77.5 MB


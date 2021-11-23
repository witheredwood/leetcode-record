来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/increasing-subsequences

实现语言：Java

@[TOC](目录)

##  题目

给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。

**示例**

```
输入：[4, 6, 7, 7]
输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
```

## 方法：回溯

**代码实现**

```java
class Solution {
    Set<List<Integer>> set = new HashSet<>();  // 用于去重重复的列表
    Stack<Integer> stack = new Stack<>();  // 存储遍历过程中的路径
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        // 开始遍历的起点
        for (int i = 0; i < nums.length-1; i++) {
            stack.push(nums[i]);
            dfs(nums, i);
            stack.pop();
        }

        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> tmp: set) {
            res.add(tmp);
        }
        return res;
    }
   public void dfs(int[] nums, int index) {
       // 出口条件
        if (index >= nums.length-1) return;

        for (int i = index+1; i < nums.length; i++) {
            // 当元素的值不小于前一个元素的值时，才进行遍历
            if (nums[i] >= nums[index]) {
                stack.push(nums[i]);
                dfs(nums, i);
                // 遍历回来时输出当前栈中的元素
                set.add(new LinkedList<>(stack));
                stack.pop();
            }
        }
    }

}
```



执行用时：40 ms

内存消耗：53.1 MB
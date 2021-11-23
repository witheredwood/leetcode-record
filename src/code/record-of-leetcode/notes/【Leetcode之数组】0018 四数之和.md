# 【Leetcode之数组】0018 四数之和

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/4sum/

实现语言：Java



##  题目

给定一个包含 n 个整数的数组 `nums` 和一个目标值 `target`，判断 `nums` 中是否存在四个元素 a，b，c 和 d ，使得 `a + b + c + d` 的值与 `target` 相等？找出所有满足条件且不重复的四元组。

注意：答案中不可以包含重复的四元组。

**示例**

```
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

输入：nums = [], target = 0
输出：[]
```



## 方法：双指针法

**Step1 排序**

先对数组进行排序，以便不记录重复的三元组。

**Step2 三层遍历**

在遍历时，需要**跳过重复的值**，这样不会记录重复的三元组。同样，a、b、c、d都需要跳过重复的值。

```java
import java.util.Arrays;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);  //O(nlogn)

        int len = nums.length;
        if (len<4) return result;

        int a,b,c,d; // a<b<c<d
        for (int i=0; i<len-3; ) {
            a = nums[i];
            for (int j=i+1; j<len-2; ) {
                b = nums[j];
                for (int k=j+1, m=len-1; k<m; ){
                    c = nums[k];
                    d = nums[m];
                    if (a+b+c+d < target) { 
                        k++;
                        continue;
                    }
                    if (a+b+c+d > target) {
                        m--;
                        continue;
                    } 
                    if (a+b+c+d == target) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(a);
                        tmp.add(b);
                        tmp.add(c);
                        tmp.add(d);
                        result.add(tmp);
                        k++; m--;
                        // 跳过重复的值
                        while (k<m && nums[k] == c) k++;
                        while (k<m && nums[m] == d) m--;
                    }
                }
                // 跳过重复的值
                j++;
                while (j<len-2 && nums[j] == b) j++;       
            }
            // 跳过重复的值
            i++;
            while (i<len-3 && nums[i] == a) i++;
        }
        return result;
    }
}
```

时间复杂度：O(n^3)		空间复杂度：O(1)

执行用时：15 ms

内存消耗：39 MB


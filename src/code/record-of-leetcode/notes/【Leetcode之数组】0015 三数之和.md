# 【Leetcode之数组】0015 三数之和

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/3sum/

实现语言：Java



##  题目

给你一个包含 n 个整数的数组 `nums`，判断 `nums` 中是否存在三个元素 `a，b，c` ，使得 `a + b + c = 0` ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

**示例**

```
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

输入：nums = [0]
输出：[]
```



## 方法一：双指针法

数组中包含重复值，如`[-4,-1,-1,0,1,2]`。先对数组进行排序，以便不记录重复的三元组。

`a`的值（下标为`i`），在遍历时，需要跳过重复的值（跳过第二个`-1`），这样不会记录重复的三元组。同样，`b`、`c`都需要跳过重复的值。

```java
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 异常情况
        if (nums.length<3) return result;
        // 排序，避免查找重复的三元组
        Arrays.sort(nums);  // nlogn  
        // 查找
        int a,b,c;  //a<b<c
        for (int i=0; i<nums.length-2;) {   
            a = nums[i]; 
            if (a>0) break; 
            for (int j = i+1, k=nums.length-1; j<k;) {
                b = nums[j];
                c = nums[k];
                if (b+c > -a) k--;
                if (b+c < -a) j++;
                if (b+c == -a) {
                    // add a/b/c to list
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(a);
                    tmp.add(b);
                    tmp.add(c);
                    // add list to the finall result
                    result.add(tmp);
                    // 跳过重复的值
                    j++; k--;
                    while (j<k && nums[j] == b) j++;
                    while (j<k && nums[k] == c) k--;
                }
            }
            // 跳过重复的值
            i++;
            while (i<nums.length-2 && nums[i] == a) i++;
        }
        return result;
    }
}
```

时间复杂度：O(n^2)		空间复杂度：O(1)

执行用时：21 ms

内存消耗：42.7 MB

## 方法二：哈希法


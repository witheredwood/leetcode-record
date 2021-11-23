# 【Leetcode之树】0108 将有序数组转换为二叉搜索树

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree

实现语言：Java

@[TOC](目录)

##  题目

给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

**示例**

```

	  0
     / \
   -3   9
   /   /  
 -10  5   

输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

	  0
     / \
  -10   5
     \   \
     -3   9   
```

```
输入：nums = [1,3]
输出：[3,1]
解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
	  3      	  1
     /             \
    1               3
```

## 方法：中序遍历

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        TreeNode root = tree(nums, 0, nums.length-1);
        return root;
    }
    public TreeNode tree(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode l = tree(nums, left, mid-1);
        TreeNode r = tree(nums, mid+1, right);
        root.left = l;
        root.right = r;
        return root;
    }
}
```

n 为以 root 为根结点的树的结点数。

时间复杂度：O( n) )

空间复杂度：O( logn )  

执行用时：0 ms

内存消耗：38.3 MB

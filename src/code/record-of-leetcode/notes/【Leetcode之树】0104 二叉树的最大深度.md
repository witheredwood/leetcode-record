# 【Leetcode之树】0104 二叉树的最大深度

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

实现语言：Java

@[TOC](目录)

##  题目

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

**说明:** 叶子节点是指没有子节点的节点。

**示例**

```
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。

## 方法：递归

**代码实现**

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
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int l = 0, r = 0;
        if (root.left!=null)  l = maxDepth(root.left);
        if (root.right!=null)  r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }
}
```

n 为以 root 为根结点的树的结点数，h 是树的高度。

时间复杂度：O( n) )

空间复杂度：O( h )  

执行用时：0 ms

内存消耗：38.5 MB

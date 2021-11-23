# 【Leetcode之树】0110 平衡二叉树

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/balanced-binary-tree/

实现语言：Java

@[TOC](目录)

##  题目

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

> 一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过 1 。

**示例**

```
    3
   / \
  9  20
    /  \
   15   7
输入：root = [3,9,20,null,null,15,7]
输出：true

        1
       / \
      2   2
     / \
    3   3
   / \  
  4   4
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false

输入：root = []
输出：true
```

## 方法：

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left==null && root.right==null) return true;
        // 左子树或右子树不平衡，则返回false
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;
        // 计算左子树的高度
        int l = height(root.left);
        // 计算右子树的高度
        int r = height(root.right);
        // 左子树和右子树的高度相差超过1，则树不平衡
        if (l-r>1 || l-r<-1) return false;
        // 否则，树是平衡的
        return true;
    }
    // 计算树的高度
    public int height(TreeNode root) {
        // 树空，则高度为0
        if (root == null) return 0;
        int l = 0, r = 0;
        // 左子树不空，计算左子树的高度
        if (root.left != null) l = height(root.left);
        // 右子树不空，计算右子树的高度
        if (root.right != null) r = height(root.right);
        // 返回树的高度
        return Math.max(l,r)+1;
    }
}
```

n 为二叉树的结点数。

时间复杂度：O( n^2 )  最坏情况下，二叉树是满二叉树，需要遍历二叉树中的所有节点，时间复杂度是 O(n))。对于节点 p，如果它的高度是 d*d*，则 height(p) 最多会被调用 d次。一棵树的高度最多是 O(n)。所以，总的复杂度是O(n^2)

空间复杂度：O(n) ，其中 n 是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。

执行用时：1 ms

内存消耗：38.4 MB

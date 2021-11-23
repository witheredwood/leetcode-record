# 【Leetcode之树】0101 对称二叉树

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/symmetric-tree

实现语言：Java

@[TOC](目录)

##  题目

给定一个二叉树，检查它是否是镜像对称的。

**示例**

```
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
```

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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        if (root.left==null && root.right==null) return true;
        // 翻转左子树
        root.left = reverse(root.left);
        // 判断左子树是否与右子树相等
        boolean res = isSame(root.left, root.right);
        return res;
    }
    // 翻转左子树
    public TreeNode reverse(TreeNode root) {
        if (root==null) return root;
        if (root.left==null && root.right==null) return root;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        root.left = reverse(root.left);
        root.right = reverse(root.right);
        return root;
    }
    // 判断树p与树q是否相等
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null && q!=null) return false;
        if (p!=null && q==null) return false;

        if(p.val!=q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
```

n 为以 root 为根结点的树的结点数。

时间复杂度：O( n) )

空间复杂度：O( n )  空间复杂度取决于递归调用的层数

执行用时：0 ms

内存消耗：36.3 MB

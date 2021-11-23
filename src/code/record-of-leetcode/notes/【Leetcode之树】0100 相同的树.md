# 【Leetcode之树】0100 相同的树

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/same-tree/

实现语言：Java

@[TOC](目录)

##  题目

给你两棵二叉树的根节点 `p` 和 `q` ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

**示例**



```
    1			 1
   / \			/ \
  2   3		   2   3	
输入：p = [1,2,3], q = [1,2,3]
输出：true

    1			 1
   /  			  \
  2    		       2	
输入：p = [1,2], q = [1,null,2]
输出：false

    1			 1
   / \			/ \
  2   1		   1   2	
输入：p = [1,2,1], q = [1,1,2]
输出：false
```

## 方法：前序遍历

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if ((p!=null && q==null) || (p==null && q!=null)) return false;
        if (p.val!=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

m 为 p 的结点数，n 为 q 的结点数。

时间复杂度：O( min(m,n) )

空间复杂度：O( min(m,n) )  空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，

执行用时：0 ms

内存消耗：36.1 MB

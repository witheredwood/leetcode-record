# 【Leetcode之树】0098 验证二叉搜索树

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/validate-binary-search-tree

实现语言：Java

@[TOC](目录)

##  题目

给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

**示例**

```
输入:
    2
   / \
  1   3
输出: true

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
```

## 方法：中序遍历

利用性质：二叉搜索树的中序遍历是升序的。

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
 import java.util.LinkedList;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        LinkedList<Integer> res = new LinkedList<Integer>();
        traverse(root, res);
        // 判断是否为升序
        for (int i=0; i<res.size()-1; i++) {
            if (res.get(i)>=res.get(i+1)) return false;
        }
        return true;
    }
    //
    public void traverse(TreeNode root, LinkedList<Integer> list) {
        if (root==null) return ;
        // 左子树存在
        if (root.left!=null) traverse(root.left, list);
        list.add(root.val);
        // 右子树存在
        if (root.right!=null) traverse(root.right, list);
    }
}
```

时间复杂度：O( n )

空间复杂度：O( n )

执行用时：111 ms

内存消耗：38.4 MB

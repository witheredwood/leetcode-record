# 【Leetcode之树】0094 二叉树的中序遍历

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

实现语言：Java

@[TOC](目录)

##  题目

给定一个二叉树的根节点 `root` ，返回它的 **中序** 遍历。

**示例**

```
    1
     \
      2
     /  
    3  

输入：root = [1,null,2,3]
输出：[1,3,2]

输入：root = []
输出：[]

输入：root = [1]
输出：[1]
```

```
    1
   / 
  2  
输入：root = [1,2]
输出：[2,1]
```

```
    1
  	 \
 	  2
输入：root = [1,null,2]
输出：[1,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root==null) return res;
        traverse(root, res);   
        return res;
    }
    public void traverse(TreeNode root, List<Integer> list) {
        // 若左子树存在，遍历左子树
        if (root.left!=null) traverse(root.left, list);
        // 遍历根节点
        list.add(root.val);
        // 若右子树存在，遍历右子树
        if (root.right!=null) traverse(root.right, list);
    }
}
```

执行用时：0 ms

内存消耗：37 MB

# 【Leetcode之树】0111 二叉树的最小深度

来源：力扣（LeetCode）

链接：[https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/)

实现语言：Java

@[TOC](目录)

##  题目

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。 

**示例**

```
    3
   / \
  9  20
    /  \
   15   7
输入：root = [3,9,20,null,null,15,7]
输出：2

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
```

## 方法：层次遍历

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
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode first = queue.peek(), last = queue.peek();
        int count = 0;
        while(queue.size()!=0) {
            TreeNode cur = queue.peek();
            // 当前结点是一层的第一个结点
            if (cur==first) {
                count++;
            }
            // 找到第一个叶结点
            if (cur.left==null && cur.right==null) break;
            // 将当前结点的左右子树入队
            if (cur.left!=null) queue.offer(cur.left);
            if (cur.right!=null) queue.offer(cur.right);
            // 弹出队首结点
            queue.poll();  
            // 当前结点是一层的最后一个结点
            if (cur==last) {              
                first = queue.peek();
                last = queue.peekLast();
            }
        }
        return count;
    }
}
```

n 为二叉树的结点数。

时间复杂度：O( n )  最多遍历一遍所有的结点

空间复杂度：O(n) 

执行用时：1 ms

内存消耗：57.9 MB

# 【Leetcode之树】0107 二叉树的层序遍历 II

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii

实现语言：Java

@[TOC](目录)

##  题目

给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

**示例**

```
例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：

[
  [15,7],
  [9,20],
  [3]
]
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
import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode first = root, last = root;
        queue.offer(root);
        while (queue.size()!=0) {
            TreeNode cur = queue.peek();
            // 如果队首结点是每层的第一个结点，则输出队中所有元素
            if (cur==first) {
                LinkedList<Integer> list = new LinkedList<>();
                for (int i=0; i<queue.size(); i++) { // 遍历队列
                    list.add(queue.get(i).val);
                }
                // 将该层数据添加到最终结果索引为0的位置上
                res.add(0,list); 
            }
            // 将该结点的左右子树入队
            if (cur.left!=null) queue.offer(cur.left);
            if (cur.right!=null) queue.offer(cur.right);
            // 弹出队首元素
            queue.poll();
            // 如果队首结点是该层的最后一点结点，则更新为下一层第一个和最后一个结点的标志
            if (cur==last) {
                first = queue.peek();
                last = queue.peekLast();
            }
        }
        return res;
    }
}
```

n 为以 root 为根结点的树的结点数。

时间复杂度：O( n) )

空间复杂度：O( n )  

执行用时：1 ms

内存消耗：38.7 MB

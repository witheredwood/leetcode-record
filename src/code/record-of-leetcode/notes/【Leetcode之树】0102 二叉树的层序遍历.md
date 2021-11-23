# 【Leetcode之树】0102 二叉树的层序遍历

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

实现语言：Java

@[TOC](目录)

##  题目

给你一个二叉树，请你返回其按 **层序遍历** 得到的节点值。 （即逐层地，从左到右访问所有节点）。

**示例**

```
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
   
返回其层序遍历结果：
[
  [3],
  [9,20],
  [15,7]
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
// import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {       
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode first = root; // 标志结点，每层第一个结点
        TreeNode last = root; // 标志结点，每层最后一个结点
        queue.offer(root); //要求有根结点，不为空
        while (queue.size()!=0) {
            // 队首结点是这一层的第一个结点，此时队里只有这一层的结点
            TreeNode cur = queue.peek(); // 队首结点
            // 当当前结点为每一层的第一个结点时，队里存放的是这一层的所有结点
            // 遍历输出该层的结点的值
            if (cur==first) { 
                LinkedList<Integer> list = new LinkedList<Integer>(); 
                for (int i=0; i<queue.size(); i++) {
                    list.add(queue.get(i).val);
                }
                res.add(list);   
            }           
            // 加入该结点的左右结点
            if (cur.left!=null) queue.offer(cur.left);
            if (cur.right!=null) queue.offer(cur.right);
            //  弹出队首结点
            queue.poll();
            // 更新标志结点，如果当前结点是这一层的最后一个结点
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

执行用时：2 ms

内存消耗：38.7 MB

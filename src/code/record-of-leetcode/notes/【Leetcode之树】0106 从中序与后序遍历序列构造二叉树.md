# 【Leetcode之树】0106 从中序与后序遍历序列构造二叉树

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

实现语言：Java

@[TOC](目录)

##  题目

根据一棵树的中序遍历与后序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

**示例**

```
例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]

返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
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
import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len1 = postorder.length, len2 = inorder.length;
        if (len1 != len2) return null;
        if (len1==0 || len2==0) return null;
        // 创建根结点
        TreeNode root = new TreeNode(postorder[len1-1]);
        // 找到根结点在中序中的下标
        int index = 0;
        for (int i=0; i<len2; i++) {
            if (inorder[i]==root.val){
                index = i;
                break;
            } 
        }
        // 构建左子树
        if (index>0) {
            int[] post = Arrays.copyOfRange(postorder, 0, index);
            int[] in = Arrays.copyOfRange(inorder, 0, index);
            root.left = buildTree(in, post);
        }
        // 构建右子树
        if (index<len2-1) {
            int[] post = Arrays.copyOfRange(postorder, index, len1-1);
            int[] in = Arrays.copyOfRange(inorder, index+1, len2);
            root.right = buildTree(in, post);
        }
        return root;
    }
}
```

n 为以 root 为根结点的树的结点数。

时间复杂度：O( n) )

空间复杂度：O( n )  

执行用时：14 ms

内存消耗：88.6 MB

package code.S07_tree;

import java.util.LinkedList;

/**
 * 222. 完全二叉树的节点个数
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * 输入：root = [1]
 * 输出：1 
 * <p>
 * 提示：
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0222 {
    /**
     * 层次遍历
     *
     * @param root 完成二叉树的根节点
     * @return 完全二叉树的节点总数
     */
    public int countNodes(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int n = 0;  // 二叉树的节点数
        if (root != null) {
            queue.add(root);
        }
        while (queue.size() > 0) {
          TreeNode cur = queue.remove();  // 弹出队首节点
          n++;
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);
        }
        return n;
    }
}

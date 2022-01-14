package code.S07_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 104.二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0104 {
    /**
     * 递归解法
     *
     * @param root 二叉树根节点
     * @return 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left) + 1;
        int r = maxDepth(root.right) + 1;
        return Math.max(l, r);
    }

    /**
     * 二叉树最近公共祖先
     * 回溯
     * 时间复杂度 O(k)，空间复杂度 O(k)，其中，k 是二叉树的深度
     *
     * @param root
     * @return
     */
    public TreeNode father(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> queue1 = new LinkedList<>();
        List<TreeNode> queue2 = new LinkedList<>();
        LinkedList<TreeNode> path = new LinkedList<>();
        findSomeNode(root, p, path, queue1);
        findSomeNode(root, q, path, queue1);
        TreeNode res = null;
        while (queue1.get(0) == queue2.get(0)) {
            res = queue1.get(0);
        }
        return res;
    }

    public boolean findSomeNode(TreeNode cur, TreeNode p, LinkedList<TreeNode> path, List<TreeNode> queue) {
        if (cur == null)
            return false;
        if (cur == p) {
            queue.addAll(new LinkedList<>(path));
            return true;
        }
        path.add(cur.left);
        boolean l = findSomeNode(cur.left, p, path, queue);
        path.removeLast();
        path.add(cur.right);
        boolean r = findSomeNode(cur.right, p, path, queue);
        path.removeLast();
        return (l || r);
    }
}

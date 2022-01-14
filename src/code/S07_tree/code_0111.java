package code.S07_tree;

import java.util.LinkedList;

/**
 * 111.二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0111 {
    /**
     * 递归解法
     * 只能搜索到叶子节点，如果搜索到空节点，则会导致单只树出错
     *
     * @param root 二叉树根节点
     * @return 二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if (root.left != null) l = minDepth(root.left) + 1;
        if (root.right != null) r = minDepth(root.right) + 1;
        return Math.min(l, r);
    }

    /**
     * 迭代解法
     * 第一个叶子节点所在的层数就是最小深度
     *
     * @param root 二叉树根节点
     * @return 二叉树的最小深度
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root;
        int layer = 1;
        while (queue.size() > 0) {
            TreeNode cur = queue.remove();
            // 找到第一个叶子节点
            if (cur.left == null && cur.right == null) {
                break;
            }
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            if (cur == last) {
                layer++;
                last = cur.right != null ? cur.right : cur.left;
            }
        }
        return layer;
    }
}

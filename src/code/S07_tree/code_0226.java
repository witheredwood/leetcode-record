package code.S07_tree;

import java.util.LinkedList;

/**
 * 226.翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0226 {
    /**
     * @param root 二叉树根节点
     * @return 翻转后的二叉树根节点
     */
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (queue.size() > 0) {
            TreeNode cur = queue.remove();
            invertNodeOfRoot(cur);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return root;
    }

    public void invertNodeOfRoot(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root != null)
            invertNodeOfRoot2(root);
        return root;
    }

    public void invertNodeOfRoot2(TreeNode root) {
        if (root == null)
            return;
        invertNodeOfRoot2(root.left);
        invertNodeOfRoot2(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}

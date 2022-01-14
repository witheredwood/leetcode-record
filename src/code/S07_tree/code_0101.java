package code.S07_tree;

/**
 * 101. 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0101 {
    public boolean isSymmetric(TreeNode root) {
        TreeNode leftRoot = root.left, rightRoot = root.right;
        // 比较根节点的左右两个子树是不是一样的
        return compare(leftRoot, rightRoot);
    }

    public boolean compare(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        boolean l = compare(root1.left, root2.left);
        boolean r = compare(root1.right, root2.right);
        return l && r;
    }
}

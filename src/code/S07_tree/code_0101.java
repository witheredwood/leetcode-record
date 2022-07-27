package code.S07_tree;

/**
 * 101. 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0101 {
    /**
     * time: O(n);      space: O(n)  递归使用的栈空间
     *
     * @param root 二叉树根节点
     * @return 二叉树是否是对称的
     */
    public boolean isSymmetric(TreeNode root) {
        // 比较根节点的左右两个子树是不是对称的
        return compareSymmetric(root.left, root.right);
    }

    /**
     * @param root1 第一个节点
     * @param root2 第二个节点
     * @return 以 root1，root2 为根节点的两棵二叉树是否是对称的
     */
    private boolean compareSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return compareSymmetric(root1.left, root2.right) && compareSymmetric(root1.right, root2.left);
    }
}

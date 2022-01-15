package code.S07_tree;

/**
 * 110. 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 *  
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0110 {
    /**
     * @param root 二叉树根节点
     * @return 是不是高度平衡的二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int height = height(root);
        return height != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int l = 0, r = 0;
        if (root.left != null) l = height(root.left);
        if (root.right != null)  r =height(root.right);
        // 判断高度差
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1; // 标记不符合规则
        return Math.max(l, r) + 1;
    }
}

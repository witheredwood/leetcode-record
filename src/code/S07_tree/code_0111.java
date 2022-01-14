package code.S07_tree;

/**
 * 111.二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0111 {
    /**
     * 递归解法
     * 
     * @param root 二叉树根节点
     * @return 二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = minDepth(root.left) + 1;
        int r = minDepth(root.right) + 1;
        return Math.min(l, r);
    }
}

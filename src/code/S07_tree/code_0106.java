package code.S07_tree;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗二叉树。
 * <p>
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * 提示:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder和postorder都由 不同 的值组成
 * postorder中每一个值都在inorder中
 * inorder保证是树的中序遍历
 * postorder保证是树的后序遍历
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0106 {
    /**
     * time: O(n);      space: O(n)
     *
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @return 构造的二叉树的根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = build(postorder, 0, postorder.length, inorder, 0, inorder.length);
        return root;
    }

    private TreeNode build(int[] postorder, int low1, int high1, int[] inorder, int low2, int high2) {
        if (low1 == high1) return null;
        TreeNode root = new TreeNode(postorder[high1 - 1]);
        int pos = low2;  // 根节点在中序中的下标
        while (pos < high2 && inorder[pos] != root.val) pos++;
        int leftCount = pos - low2;
        // 递归左子树
        root.left = build(postorder, low1, low1 + leftCount, inorder, low2, pos);
        // 递归右子树
        root.right = build(postorder, low1 + leftCount, high1 - 1, inorder, pos + 1, high2);
        return root;
    }

}

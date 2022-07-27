package code.S07_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0094 {
    /**
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树根节点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    /**
     * @param root   二叉树根节点
     * @param result 存储中序遍历
     */
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    /**
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树根节点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal31(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        return result;
    }
}

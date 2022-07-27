package code.S07_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * 提示：
 * 树中节点数目范围在[1, 10^4] 内
 * -2^31 <= Node.val <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0098 {
    /**
     * 中序遍历是升序
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树的根节点
     * @return 是否是一个有效的二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        List<Integer> in = new ArrayList<>();
        inorder(root, in);
        // 是否是升序
        for (int i = 1; i < in.size(); i++) {
            if (in.get(i) <= in.get(i - 1)) return false;
        }
        return true;
    }

    /**
     * 中序遍历
     *
     * @param root   二叉树的根节点
     * @param result 存放中序遍历的链表
     */
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left != null) inorder(root.left, result);
        result.add(root.val);
        if (root.right != null) inorder(root.right, result);
    }
}

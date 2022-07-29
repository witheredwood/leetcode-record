package code.S07_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 10^5] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0236 {


    /**
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树
     * @param p    节点
     * @param q    节点
     * @return 两个指定节点的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        List<TreeNode> path1 = new LinkedList<>();
        List<TreeNode> path2 = new LinkedList<>();
        path1.add(root);
        if (!getPath(root, p, path1)) path1.remove(path1.size() - 1);
        path2.add(root);
        if (!getPath(root, q, path2)) path2.remove(path2.size() - 1);
        TreeNode res = root;
        for (int i = 0; i < path1.size() && i < path2.size() && path1.get(i).val == path2.get(i).val; i++) {
            res = path1.get(i);
        }
        return res;
    }

    private boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        if (root.val == target.val) {
            return true;
        }
        boolean l = false, r = false;
        if (root.left != null) {
            path.add(root.left);
            l = getPath(root.left, target, path);
            if (!l) path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right);
            r = getPath(root.right, target, path);
            if (!r) path.remove(path.size() - 1);
        }
        return l || r;
    }

}

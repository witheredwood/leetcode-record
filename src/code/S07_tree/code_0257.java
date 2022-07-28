package code.S07_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 * 提示：
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0257 {
    /**
     * time: O(n);      space: O(logn) ~ O(n)
     *
     * @param root 二叉树的根节点
     * @return 所有从根节点到叶子节点的路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        getPath(root, path, result);
        return result;
    }

    private void getPath(TreeNode root, StringBuilder path, List<String> result) {
        if (root == null) return;
        // 叶子节点
        if (root.left == null && root.right == null) {
            result.add(path.toString());
            return;
        }
        // 非叶子节点
        if (root.left != null) {
            String s = "->" + root.left.val;
            path.append(s);
            getPath(root.left, path, result);
            path.delete(path.length() - s.length(), path.length());
        }
        if (root.right != null) {
            String s = "->" + root.right.val;
            path.append(s);
            getPath(root.right, path, result);
            path.delete(path.length() - s.length(), path.length());
        }
    }
}

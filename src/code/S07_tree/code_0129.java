package code.S07_tree;

/**
 * 129. 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * <p>
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0129 {
    private int sum = 0;

    /**
     * 递归
     * time: O(n);      space: O(logn) ~ O(n)
     *
     * @param root 二叉树的根节点
     * @return 计算从根节点到叶节点生成的 所有数字之和
     */
    public int sumNumbers31(TreeNode root) {
        if (root == null) return 0;
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        return recursive(root, path);
    }

    private int recursive(TreeNode root, StringBuilder path) {
        if (root == null) return 0;
        // 叶子节点
        if (root.left == null && root.right == null) {
            return Integer.parseInt(path.toString());
        }
        // 非叶子节点
        int l = 0, r = 0;
        if (root.left != null) {
            int beforeLen = path.length();
            path.append(root.left.val);
            int afterLen = path.length();
            l = recursive(root.left, path);
            path.delete(path.length() - afterLen + beforeLen, path.length());
        }
        if (root.right != null) {
            int beforeLen = path.length();
            path.append(root.right.val);
            int afterLen = path.length();
            r = recursive(root.right, path);
            path.delete(path.length() - afterLen + beforeLen, path.length());
        }
        return l + r;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        StringBuilder path = new StringBuilder();
        traverse(root, path);
        return sum;
    }

    public void traverse(TreeNode root, StringBuilder path) {
        if (root.left == null && root.right == null) {
            path.append(root.val);
            sum += Integer.valueOf(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }

        // 访问节点
        path.append(root.val);
        // 遍历子树
        if (root.left != null) traverse(root.left, path);
        if (root.right != null) traverse(root.right, path);
        // 遍历完成之后
        path.deleteCharAt(path.length() - 1);
    }
}

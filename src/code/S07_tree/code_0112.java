package code.S07_tree;

/**
 * 112. 路径总和
 * <p>
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * <p>
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0112 {
    /**
     * 递归，注意进入函数和跳出函数
     * time: O(n);      space: O(h) .h 是二叉树的高度
     * space: O(logn) - O(n)
     *
     * @param root      二叉树的根节点
     * @param targetSum 表示目标和的整数
     * @return 该树中是否存在 根节点到叶子节点 的路径
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        // 进入该函数的不会是空节点
        sum += root.val;
        // 遇到叶子节点，则判断是否满则条件，跳出
        if (root.left == null && root.right == null) {
            return targetSum == sum;
        }
        // 遇到非叶子节点，则递归
        boolean l = false, r = false;
        if (root.left != null) l = hasPathSum(root.left, targetSum, sum);
        if (root.right != null) r = hasPathSum(root.right, targetSum, sum);
        return (l || r);
    }

}

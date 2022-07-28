package code.S07_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0113 {
    /**
     * @param root      二叉树的根节点
     * @param targetSum 整数目标和
     * @return 所有 从根节点到叶子节点 路径总和等于给定目标和的路径
     */
    public List<List<Integer>> pathSum31(TreeNode root, int targetSum) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        recursive(root, targetSum, root.val, path, result);
        return result;
    }

    private void recursive(TreeNode root, int target, int sum, LinkedList<Integer> path, List<List<Integer>> result) {
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (target == sum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // 非叶子节点
        if (root.left != null) {
            path.add(root.left.val);
            recursive(root.left, target, sum + root.left.val, path, result);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right.val);
            recursive(root.right, target, sum + root.right.val, path, result);
            path.removeLast();
        }
    }
}

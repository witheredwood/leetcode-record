package code.S07_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0102 {
    /**
     * 层次遍历
     *
     * @param root 二叉树根节点
     * @return 二叉树层次遍历中每层的节点
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode last = null;
        if (root != null) {
            queue.add(root);
            last = root;
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            level.add(cur.val);
            // 加入2个子节点
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
            if (cur == last) {
                if (!queue.isEmpty()) last = queue.getLast();
                list.add(new LinkedList<>(level));
                level.clear();
            }
        }
        System.out.println("list = " + list);
        return list;
    }
}

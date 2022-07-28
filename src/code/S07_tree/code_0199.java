package code.S07_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1,3,4]
 * 示例 2:
 * 输入:[1,null,3]
 * 输出:[1,3]
 * 示例 3:
 * 输入:[]
 * 输出:[]
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100<= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0199 {
    /**
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树的 根节点
     * @return 从右侧所能看到的节点值
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        TreeNode last = queue.isEmpty() ? null : queue.getLast();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) queue.offer(curNode.left);
            if (curNode.right != null) queue.offer(curNode.right);
            if (curNode == last) {
                if (!queue.isEmpty()) last = queue.getLast();
                result.add(curNode.val);
            }
        }
        return result;
    }
}

package code.S07_tree;

import java.util.LinkedList;

/**
 * 513. 找树左下角的值
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * <p>
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [1,10^4]
 * -2^31 <= Node.val <= 2^31- 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0513 {
	/**
	 * @param root 二叉树的根节点
	 * @return
	 */
	public int findBottomLeftValue(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode first = root, last = root;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			if (cur.left != null) queue.offer(cur.left);
			if (cur.right != null) queue.offer(cur.right);

			if (cur == last && !queue.isEmpty()) {
				first = queue.getFirst();
				last = queue.getLast();
			}
		}
		return first.val;
	}
}

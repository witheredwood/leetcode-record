package code.S07_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * <p>
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * 提示：
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0589 {
	/**
	 * 迭代法
	 *
	 * @param root 当前遍历到的树的节点
	 * @return 树的前序遍历结果
	 */
	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		LinkedList<Node> stack = new LinkedList<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node cur = stack.removeLast();
			res.add(cur.val);
			for (int i = cur.children.size() - 1; i >= 0; i--) {
				stack.add(cur.children.get(i));
			}
		}
		return res;
	}

	/**
	 * 递归法
	 *
	 * @param root 当前遍历到的树的节点
	 * @return 树的前序遍历结果
	 */
	public List<Integer> preorder1(Node root) {
		List<Integer> res = new ArrayList<>();
		traverse(root, res);
		return res;
	}

	/**
	 * 前序遍历
	 *
	 * @param root 当前遍历到的树的节点
	 * @param res  存储树中节点的链表
	 */
	public void traverse(Node root, List<Integer> res) {
		if (root == null) return;

		res.add(root.val);
		for (Node node : root.children) {
			traverse(node, res);
		}
	}
}

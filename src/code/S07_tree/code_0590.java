package code.S07_tree;

import java.util.*;

/**
 * 590. N 叉树的后序遍历
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * 提示：
 * 节点总数在范围 [0, 104] 内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0590 {
	/**
	 * 迭代法
	 *
	 * @param root 当前遍历到的树的节点
	 * @return 树的后序遍历结果
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		LinkedList<Node> stack = new LinkedList<>();
		Map<Node, Boolean> visited = new HashMap<>();
		if (root != null) {
			stack.add(root);
			if (root.children.size() > 0) visited.put(root, false);
		}
		while (!stack.isEmpty()) {
			Node top = stack.getLast();
			if (top.children == null || top.children.size() == 0 || visited.get(top)) {
				stack.removeLast();
				res.add(top.val);
			} else {
				for (int i = top.children.size() - 1; i >= 0; i--) {
					Node node = top.children.get(i);
					stack.add(node);
					if (node.children != null && node.children.size() > 0) visited.put(node, false);
				}
				visited.replace(top, true);
			}
		}
		return res;
	}

	/**
	 * 递归法
	 *
	 * @param root 当前遍历到的树的节点
	 * @return 树的后序遍历结果
	 */
	public List<Integer> postorder1(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		traverse(root, res);
		res.add(root.val);
		return res;
	}

	/**
	 * 后序遍历
	 *
	 * @param root 当前遍历到的树的节点
	 * @param res  存储树中节点的链表
	 */
	public void traverse(Node root, List<Integer> res) {
		if (root.children.size() == 0) {
			return;
		}
		for (Node node : root.children) {
			traverse(node, res);
			res.add(node.val);
		}
	}
}

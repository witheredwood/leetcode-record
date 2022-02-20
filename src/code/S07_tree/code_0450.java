package code.S07_tree;

/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 示例 1:
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * 提示:
 * 节点数的范围 [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * 节点值唯一
 * root是合法的二叉搜索树
 * -10^5 <= key <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0450 {
	/**
	 * @param root 二叉搜索树的根节点
	 * @param key  要删除的节点的值
	 * @return 删除节点后的二叉搜索树的根节点
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode newRoot = new TreeNode(0);
		newRoot.left = root;
		TreeNode pre = newRoot, delete = root;
		// 找到被删除节点的父节点
		while (delete != null) {
			if (delete.val == key) break;
			pre = delete;
			delete = delete.val < key ? delete.right : delete.left;
		}
		// 没找到
		if (delete == null) return root;
		// 没有右子树
		if (delete.right == null) {
			if (delete == pre.left) pre.left = delete.left;
			else pre.right = delete.left;
		} else {
			TreeNode p = delete.right, q = delete;
			for (; p.left != null; q = p, p = p.left) ;
			delete.val = p.val;
			if (p == delete.right) q.right = p.right;
			else q.left = p.right;
		}
		return newRoot.left;
	}
}

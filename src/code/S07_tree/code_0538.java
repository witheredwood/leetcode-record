package code.S07_tree;

import java.util.LinkedList;

/**
 * 538. 把二叉搜索树转换为累加树
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 示例 1
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 * <p>
 * 提示：
 * 树中的节点数介于 0和 10^4之间。
 * 每个节点的值介于 -10^4和10^4之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0538 {
    /**
     * time: O(n);      space: O(n)
     *
     * @param root 二叉 搜索 树的根节点
     * @return 累加树的根节点
     */
    public TreeNode convertBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = null, pre = null;
        if (root != null) curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {  // 当前访问节点，访问到最底层
                stack.push(curNode);  // 当前节点不为空，则将该节点加入到栈中
                curNode = curNode.right;
            } else {   // 当前访问节点为空，则弹出栈顶元素
                curNode = stack.pop();
                if (pre != null) curNode.val += pre.val;
                pre = curNode;
                curNode = curNode.left;
            }
        }
        return root;
    }
}

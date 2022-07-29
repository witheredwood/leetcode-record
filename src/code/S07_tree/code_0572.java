package code.S07_tree;

import java.util.LinkedList;

/**
 * 572. 另一棵树的子树
 * <p>
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1：
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 * <p>
 * 提示：
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -10^4 <= root.val <= 10^4
 * -10^4 <= subRoot.val <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0572 {
    /**
     * 判断子树递归 + 判断相同树递归
     * time: O(nlogn+mlogn);        space: O(logn)
     * ???不会算了 ，好像不是这个吧
     *
     * @param root    二叉树根节点
     * @param subRoot 二叉树根节点
     * @return root 中是否包含和 subRoot 具有相同结构和节点值的子树
     */
    public boolean isSubtree32(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            boolean res = isSame(root, subRoot);
            if (res) return true;
        }
        return isSubtree32(root.left, subRoot) || isSubtree32(root.right, subRoot);
    }

    /**
     * 判断两棵树是否相同
     * time: O(n+m) ;    space: O(logn + logm)
     *
     * @param root1 二叉树根节点
     * @param root2 二叉树根节点
     * @return 两棵树是否相同
     */
    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    /**
     * time: O(nlogn);      space: O(nlogn)
     *
     * @param root    二叉树根节点
     * @param subRoot 二叉树根节点
     * @return root 中是否包含和 subRoot 具有相同结构和节点值的子树
     */
    public boolean isSubtree31(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        String subInorder = inorder(subRoot);
        String subPreorder = preorder(subRoot);
        if (subInorder.equals(inorder(root)) && subPreorder.equals(preorder(root))) return true;
        return isSubtree31(root.left, subRoot) || isSubtree31(root.right, subRoot);
    }

    private String inorder(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                builder.append(curNode.val + ".");
                curNode = curNode.right;
            }
        }
        return builder.toString();
    }

    private String preorder(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            builder.append(curNode.val + ".");
            if (curNode.right != null) stack.push(curNode.right);
            if (curNode.left != null) stack.push(curNode.left);
        }
        return builder.toString();
    }

}

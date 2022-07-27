package code.S07_tree;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0105 {
    /**
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 构造的二叉树的根节点
     */
    public TreeNode buildTree31(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int low1, int high1, int[] inorder, int low2, int high2) {
        if (low1 == high1) return null;
        TreeNode root = new TreeNode(preorder[low1]);
        int pos = low2;  // 根节点在中序中的下标
        while (pos < high2 && root.val != inorder[pos]) pos++;
        int leftCount = pos - low2;
        // 递归左子树
        root.left = build(preorder, low1 + 1, low1 + leftCount + 1, inorder, low2, pos);
        // 递归右子树
        root.right = build(preorder, low1 + leftCount + 1, high1, inorder, pos + 1, high2);
        return root;
    }

    /**
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 构造的二叉树的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    /**
     * @param preorder 前序遍历，数组范围是 [low1, high1]
     * @param low1     前序遍历的起点
     * @param high1    前序遍历的终点
     * @param inorder  中序遍历，数组范围是 [low2, high2]
     * @param low2     中序遍历的起点
     * @param high2    中序遍历的终点
     * @return 构造的二叉树的根节点
     */
    public TreeNode buildSubTree(int[] preorder, int low1, int high1, int[] inorder, int low2, int high2) {
        System.out.println("buildSubTree  >>>> ");
        System.out.println("low1: " + low1 + " high1: " + high1 + " low2: " + low2 + " high2: " + high2);
        if (low1 > high1 || low2 > high2) return null;
        if (low1 == high1 && low2 == high2) return new TreeNode(preorder[low1]);
        // 找到根节点在中序遍历中的下标
        int index = findRoot(preorder, low1, high1, inorder, low2, high2);
        System.out.println("index = " + index);
        int lLen = index - low2;
        System.out.println("lLen = " + lLen);
        // 找到左右子树的根节点
        TreeNode left = buildSubTree(preorder, low1 + 1, low1 + lLen, inorder, low2, index - 1);
        System.out.println("left = " + left.val);
        TreeNode right = buildSubTree(preorder, low1 + 1 + lLen, high1, inorder, index + 1, high2);
        System.out.println("right = " + right.val);
        TreeNode root = new TreeNode(preorder[low1], left, right);
        System.out.println("root = " + root.val);
        System.out.println("==============");
        return root;
    }

    /**
     * @param preorder 前序遍历，数组范围是 [low1, high1]
     * @param low1     前序遍历的起点
     * @param high1    前序遍历的终点
     * @param inorder  中序遍历，数组范围是 [low2, high2]
     * @param low2     中序遍历的起点
     * @param high2    中序遍历的终点
     * @return 根节点在中序遍历中的下标
     */
    public int findRoot(int[] preorder, int low1, int high1, int[] inorder, int low2, int high2) {
        for (int index = low2; index <= high2; index++) {
            if (inorder[index] == preorder[low1]) {
                return index;
            }
        }
        return -1;
    }

}

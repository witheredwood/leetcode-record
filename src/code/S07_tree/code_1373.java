package code.S07_tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1373. 二叉搜索子树的最大键值和
 * <p>
 * 给你一棵以root为根的二叉树，请你返回 任意二叉搜索子树的最大键值和。
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都小于此节点的键值。
 * 任意节点的右子树中的键值都 大于此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 * <p>
 * 示例 1：
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 * <p>
 * 提示：
 * 每棵树有 1 到 40000个节点。
 * 每个节点的键值在[-4 * 10^4, 4 * 10^4] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1373 {
    int maxValue = 0;

    /**
     * 后序遍历，
     * 方案一：返回中序序列，中序序列用于判断是否是二叉搜索树
     * 方案二：返回左右子树的[和，最小值，最大值]
     *
     * @param root 二叉树根节点
     * @return 任意 二叉搜索子树的最大键值和
     */
    public int maxSumBST(TreeNode root) {
        postorderArray(root);
//        postorder(root);
        return maxValue;
    }

    /**
     * @param root
     * @return 数组 [和，最小值，最大值]
     */
    private int[] postorderArray(TreeNode root) {
        // 叶子节点
        if (root.left == null && root.right == null) {
            maxValue = Math.max(maxValue, root.val);
            return new int[]{root.val, root.val, root.val};
        }
        // 非叶子节点
        int[] arr1 = null, arr2 = null;
        // 求左右子树的[和，最小值，最大值]
        // 只有右子树
        if (root.left == null) {
            arr2 = postorderArray(root.right);
            if (arr2 == null || root.val >= arr2[1]) return null;
            arr2[0] += root.val;
            maxValue = Math.max(maxValue, arr2[0]);
            return new int[]{arr2[0], root.val, arr2[2]};
        }
        // 只有左子树
        if (root.right == null) {
            arr1 = postorderArray(root.left);
            if (arr1 == null || root.val <= arr1[2]) return null;
            arr1[0] += root.val;
            maxValue = Math.max(maxValue, arr1[0]);
            return new int[]{arr1[0], arr1[1], root.val};
        }
        // 双子树
        arr1 = postorderArray(root.left);
        arr2 = postorderArray(root.right);
        if (arr1 == null || root.val <= arr1[2]) return null;
        if (arr2 == null || root.val >= arr2[1]) return null;
        int[] res = new int[]{arr1[0] + root.val + arr2[0], arr1[1], arr2[2]};
        maxValue = Math.max(maxValue, res[0]);
        return res;
    }

    private List<Integer> postorder(TreeNode root) {
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (root.val > maxValue) maxValue = root.val;
            List<Integer> list = new LinkedList<>();
            Collections.addAll(list, new Integer[]{root.val, root.val});
            return list;
        }
        // 只有右子树
        if (root.left == null) {
            List<Integer> rInorder = postorder(root.right);
            if (rInorder == null || (rInorder.size() > 1 && root.val >= rInorder.get(1)))
                return null;
            rInorder.set(0, rInorder.get(0) + root.val);
            rInorder.add(1, root.val);
            if (rInorder.get(0) > maxValue) maxValue = rInorder.get(0);
            return rInorder;
        }
        // 只有左子树
        if (root.right == null) {
            List<Integer> lInorder = postorder(root.left);
            if (lInorder == null || (lInorder.size() > 1 && root.val <= lInorder.get(lInorder.size() - 1)))
                return null;
            lInorder.set(0, lInorder.get(0) + root.val);
            lInorder.add(root.val);
            if (lInorder.get(0) > maxValue) maxValue = lInorder.get(0);
            return lInorder;
        }
        // 双子树
        List<Integer> lInorder = postorder(root.left);
        List<Integer> rInorder = postorder(root.right);
        if (rInorder == null || (rInorder.size() > 1 && root.val >= rInorder.get(1))) return null;
        if (lInorder == null || (lInorder.size() > 1 && root.val <= lInorder.get(lInorder.size() - 1)))
            return null;
        lInorder.set(0, lInorder.get(0) + rInorder.get(0) + root.val);
        lInorder.add(root.val);
        lInorder.addAll(rInorder);
        if (lInorder.get(0) > maxValue) maxValue = lInorder.get(0);
        return lInorder;
    }
}

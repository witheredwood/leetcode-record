package code.S07_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 * <p>
 * 给你一棵二叉搜索树，请你返回一棵平衡后的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是平衡的 。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 * 示例 2：
 * 输入: root = [2,1,3]
 * 输出: [2,1,3]
 * <p>
 * 提示：
 * 树节点的数目在[1, 10^4]范围内。
 * 1 <= Node.val <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/balance-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1382 {

    /**
     * 从中序遍历列表中重新构造二叉搜索树，而不是调整二叉搜索树
     * time: O(n);     space: O(n)
     *
     * @param root 二叉搜索树根节点
     * @return 平衡后 的二叉搜索树根节点
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        int[] nums = Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
        TreeNode res = build(nums, 0, nums.length);
        return res;
    }

    /**
     * 构造二叉树
     * time: O(n);     space: O(logn)
     *
     * @param nums 中序遍历数组
     * @param low  起始下标
     * @param high 结束下标
     * @return
     */
    private TreeNode build(int[] nums, int low, int high) {
        if (low == high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, low, mid);
        root.right = build(nums, mid + 1, high);
        return root;
    }

    /**
     * 中序遍历
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树根节点
     * @param list 存储中序遍历列表
     */
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

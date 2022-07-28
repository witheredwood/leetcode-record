package code.S07_tree;

public class code_0108 {
    /**
     * 转换为一棵 高度平衡 二叉搜索树
     * time: O(n);      space: O(logn)
     *
     * @param nums 整数数组，升序 排列
     * @return 二叉搜索树的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low == high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, low, mid);
        root.right = build(nums, mid + 1, high);
        return root;
    }
}

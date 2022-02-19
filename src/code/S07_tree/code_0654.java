package code.S07_tree;

/**
 * 654. 最大二叉树
 * <p>
 * 给定一个不重复的整数数组 nums 。最大二叉树可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0654 {
	/**
	 * 递归法
	 *
	 * @param nums 整数数组，长度大于0
	 * @return 构建的二叉树的根节点
	 */
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length);
	}

	/**
	 * 构建数组中某个范围内的二叉树
	 *
	 * @param nums 整数数组，长度大于0
	 * @param low  数组的最小下标
	 * @param high 数组的最大下标
	 * @return [low, high] 内的根节点
	 */
	public TreeNode build(int[] nums, int low, int high) {
		if (low >= high) return null;
		int pos = getPosition(nums, low, high);
		TreeNode root = new TreeNode(nums[pos]);
		root.left = build(nums, low, pos);
		root.right = build(nums, pos + 1, high);
		return root;
	}

	/**
	 * 获取数组某个范围内最大值的下标
	 *
	 * @param nums 整数数组，长度大于0
	 * @param low  数组的最小下标
	 * @param high 数组的最大下标
	 * @return [low, high] 内最大值的下班
	 */
	public int getPosition(int[] nums, int low, int high) {
		int max = low;
		for (int i = low; i < high; i++) {
			if (nums[i] > nums[max]) max = i;
		}
		return max;
	}
}

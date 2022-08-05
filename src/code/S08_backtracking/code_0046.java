package code.S08_backtracking;

import java.util.*;

/**
 * 46.全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0046 {
    /**
     * @param nums 整数数组
     * @return 所有可能的全排列
     */
    public List<List<Integer>> permute31(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(nums, path, result);
        return result;
    }

    private void backtracking(int[] nums, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtracking(nums, path, result);
            path.removeLast();
        }
    }

    /**
     * 回溯
     *
     * @param nums 整数数组
     * @return 所有可能的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        /** 符合条件的结果的集合 */
        List<List<Integer>> res = new LinkedList<>();
        /** 符合条件的结果 */
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(nums, res, path);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums 整数数组
     * @param res  符合条件的结果的集合
     * @param path 符合条件的结果
     */
    public void backtracking(int[] nums, List<List<Integer>> res, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backtracking(nums, res, path);
                path.removeLast();
            }
        }
    }
}

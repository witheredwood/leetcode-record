package code.S08_backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 78.子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0078 {
    /**
     * 回溯
     *
     * @param nums 整数数组，不包含重复的数字
     * @return 所有的子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        /** 符合条件的结果的集合 */
        List<List<Integer>> res = new LinkedList<>();
        /** 符合条件的结果 */
        LinkedList<Integer> path = new LinkedList<>();
        res.add(new LinkedList<>());  // 空集
        backtracking(nums, 0, res, path);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums       整数数组，不包含重复的数字
     * @param startIndex 开始下标
     * @param res        符合条件的结果的集合
     * @param path       符合条件的结果
     */
    public void backtracking(int[] nums, int startIndex, List<List<Integer>> res, LinkedList<Integer> path) {
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, res, path);
            res.add(new LinkedList<>(path));
            path.removeLast();
        }
    }

}

package code.S08_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90.子集
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0090 {
    /**
     * 回溯
     *
     * @param nums 整数数组，可能包含重复元素
     * @return 所有子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        /** 符合条件的结果的集合 */
        List<List<Integer>> res = new LinkedList<>();
        /** 符合条件的结果 */
        LinkedList<Integer> path = new LinkedList<>();
        /** 访问数组 */
        boolean[] visited = new boolean[nums.length];
        res.add(new LinkedList<>());  // 空集
        backtracking(nums, 0, visited, res, path);
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
    public void backtracking(int[] nums, int startIndex, boolean[] visited, List<List<Integer>> res, LinkedList<Integer> path) {
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            visited[i] = false;
            path.add(nums[i]);
            backtracking(nums, i + 1, visited, res, path);
            res.add(new LinkedList<>(path));
            path.removeLast();
            visited[i] = true;
        }
    }
}

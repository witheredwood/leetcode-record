package code.S08_backtracking;

import java.util.*;

/**
 * 491. 递增子序列
 * <p>
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 示例 1：
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0491 {
    /**
     * @param nums 整数数组
     * @return 所有该数组中不同的递增子序列
     */
    public List<List<Integer>> findSubsequences31(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new LinkedList<>();
        Set<List<Integer>> result = new HashSet<>();
        backtracking(nums, 0, visited, path, result);
        return new ArrayList<>(result);
    }

    private void backtracking(int[] nums, int startIndex, boolean[] visited, List<Integer> path, Set<List<Integer>> result) {
        if (startIndex >= nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) continue;   // 当前数比上一层小
            visited[i] = false;
            path.add(nums[i]);
            if (path.size() > 1) {
                result.add(new ArrayList<>(path));
            }
            backtracking(nums, i + 1, visited, path, result);
            path.remove(path.size() - 1);
            visited[i] = true;
        }
    }

    /**
     * @param nums 整数数组
     * @return 所有该数组中不同的递增子序列
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) return new LinkedList<>();
        /** 符合条件的结果的集合，去重 */
        Set<List<Integer>> set = new HashSet<>();
        /** 符合条件的结果 */
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(nums, 0, set, path);
        System.out.println("set => " + set.toString());
        List<List<Integer>> res = new LinkedList<>(set);
        System.out.println("res => " + res.toString());
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums       整数数组，不包含重复的数字
     * @param startIndex 开始下标
     * @param set        符合条件的结果的集合
     * @param path       符合条件的结果
     */
    public void backtracking(int[] nums, int startIndex, Set<List<Integer>> set, LinkedList<Integer> path) {
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 如果当前值比path中的递增子序列小，则不加入结果集中，本次递归结束
            if (path.size() > 0 && nums[i] < path.getLast()) continue;
            path.add(nums[i]);
            backtracking(nums, i + 1, set, path);
            if (path.size() >= 2) {
                set.add(new ArrayList<>(path));
            }
            path.removeLast();
        }
    }
}

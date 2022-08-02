package code.S08_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * <p>
 * 示例1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0039 {
    /**
     * 回溯
     *
     * @param candidates 无重复元素 的整数数组
     * @param target     整数
     * @return 组成目标数的所有组合
     */
    public List<List<Integer>> combinationSum31(int[] candidates, int target) {
        // 排序，避免加入重复的路径
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(candidates, 0, 0, target, path, result);
        return result;
    }

    private void backtracking(int[] candidates, int index, int sum, int target, LinkedList<Integer> path, List<List<Integer>> result) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;   // 剪枝
            path.add(candidates[i]);
            backtracking(candidates, i, sum + candidates[i], target, path, result);
            path.removeLast();
        }
    }


    /**
     * 回溯：使用参数保存结果
     *
     * @param candidates 无重复元素 的整数数组
     * @param target     整数
     * @return 组成目标数的所有组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();  // 保存符合条件的结果的集合
        LinkedList<Integer> path = new LinkedList<>();  // 保存符合条件的结果
        int sum = 0;  // 当前总和
        backtracking(candidates, target, 0, res, path, sum);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param candidates 无重复元素 的整数数组
     * @param target     整数
     * @param startIndex 回溯开始下标
     * @param res        保存符合条件的结果的集合
     * @param path       保存符合条件的结果
     * @param sum        当前总和
     */
    public void backtracking(int[] candidates, int target, int startIndex, List<List<Integer>> res, LinkedList<Integer> path, int sum) {
        if (sum > target) return;
        if (sum == target) {
            if (path.size() > 0) res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i, res, path, sum);
            int last = path.removeLast();
            sum -= last;
        }
    }
}

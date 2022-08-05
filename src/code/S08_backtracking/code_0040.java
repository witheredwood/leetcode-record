package code.S08_backtracking;

import java.util.*;

/**
 * 40.组合总和II
 * <p>
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例1:
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例2:
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0040 {
    /**
     * @param candidates 无重复元素 的整数数组
     * @param target     整数
     * @return 组成目标数的所有组合
     */
    public List<List<Integer>> combinationSum231(int[] candidates, int target) {
        Arrays.sort(candidates);    // 升序
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(candidates, 0, 0, target, path, result);
        return result;
    }

    private void backtracking (int[] candidates, int index, int sum, int target, LinkedList<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (sum + candidates[i] > target) break;  // 后续的值不需要遍历
            path.add(candidates[i]);
            backtracking(candidates, i + 1, sum + candidates[i], target, path, result);
            path.removeLast();
        }
    }

    /**
     * 回溯（使用全局变量保存结果）+ 排序
     *
     * @param candidates 无重复元素 的整数数组
     * @param target     整数
     * @return 组成目标数的所有组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();  // 保存符合条件的结果的集合
        LinkedList<Integer> path = new LinkedList<>();  // 保存符合条件的结果
        boolean[] visited = new boolean[candidates.length];  // 回溯时同一层的数是否被访问过

        Arrays.sort(candidates);  // 排序。[2,5,2,1,2] -> [1,2,2,2,5]
        backtracking(candidates, target, 0, visited, res, path, 0);

        List<List<Integer>> list = new LinkedList<>();  // 保存符合条件的结果的集合
        list.addAll(res);
        return list;
    }

    /**
     * 回溯算法
     *
     * @param candidates 无重复元素 的整数数组
     * @param target     整数
     * @param startIndex 回溯开始下标
     */
    public void backtracking(int[] candidates, int target, int startIndex, boolean[] visited, Set<List<Integer>> res, LinkedList<Integer> path, int sum) {
        if (sum > target) return;
        if (sum == target) {
            if (path.size() > 0) res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 判断同一层的节点中是否已经访问过与当前节点相同的数
            if (i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1]) continue;
            visited[i] = false;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i + 1, visited, res, path, sum);
            // 遍历完之后，把当前的节点从路径中移除，从总和中减去，并把当前节点置为访问过
            sum -= path.removeLast();
            visited[i] = true;

        }
    }
}

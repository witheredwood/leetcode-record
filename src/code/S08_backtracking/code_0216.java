package code.S08_backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 216.组合总和III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0216 {
    List<List<Integer>> res = new LinkedList<>();  // 保存符合条件的结果的集合
    LinkedList<Integer> path = new LinkedList<>();  // 保存符合条件的结果
    int sum = 0;  // 符合条件的结果的路径的总和

    /**
     * 回溯：使用全局变量保存符合条件的结果
     *
     * @param k 整数
     * @param n 组合相加之和
     * @return 整数相加等于 n 的所有组合
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        System.out.println(res.toString());
        return res;
    }

    /**
     * 回溯算法
     *
     * @param k          整数
     * @param n          组合相加之和
     * @param startIndex 开始下标
     */
    public void backtracking(int k, int n, int startIndex) {
        if (path.size() == k) {
            if (sum == n) res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1);
            int value = path.removeLast();
            sum -= value;
        }
    }

    /**
     * 回溯：使用参数保存符合条件的结果
     *
     * @param k 整数
     * @param n 组合相加之和
     * @return 整数相加等于 n 的所有组合
     */
    public List<List<Integer>> combinationSum32(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();  // 保存符合条件的结果的集合
        LinkedList<Integer> path = new LinkedList<>();  // 保存符合条件的结果
        int sum = 0;  // 符合条件的结果的路径的总和

        backtracking2(k, n, 1, res, path, sum);
        System.out.println(res.toString());
        return res;
    }

    /**
     * 回溯算法
     *
     * @param k          整数
     * @param n          组合相加之和
     * @param startIndex 开始下标
     */
    public void backtracking2(int k, int n, int startIndex, List<List<Integer>> res, LinkedList<Integer> path, int sum) {
        if (path.size() == k) {
            if (sum == n) res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backtracking2(k, n, i + 1, res, path, sum);
            int value = path.removeLast();
            sum -= value;
        }
    }

}

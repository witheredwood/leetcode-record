package code.S08_backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *  
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0077 {
    List<List<Integer>> res = new LinkedList<>();  // 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();  // 存放符合条件的结果

    /**
     * @param n 整数
     * @param k 整数
     * @return 所有的 k 个数的组合
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        System.out.println(res.toString());
        return res;
    }

    /**
     * 回溯算法
     *
     * @param n          整数
     * @param k          整数
     * @param startIndex 开始下标
     */
    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    /**
     * 回溯算法 + 剪枝优化
     *
     * @param n          整数
     * @param k          整数
     * @param startIndex 开始下标
     */
    public void backtracking_jianzhi(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking_jianzhi(n, k, i + 1);
            path.removeLast();
        }
    }


    /**
     * @param n 整数
     * @param k 整数
     * @return 所有的 k 个数的组合
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res2 = new LinkedList<>();  // 存放符合条件结果的集合
        LinkedList<Integer> path2 = new LinkedList<>();  // 存放符合条件的结果
        backtracking2(n, k, 1, res2, path2);
        System.out.println(res2.toString());
        return res2;
    }

    /**
     * 回溯算法
     *
     * @param n          整数
     * @param k          整数
     * @param startIndex 开始下标
     */
    public void backtracking2(int n, int k, int startIndex, List<List<Integer>> res2, LinkedList<Integer> path2) {
        if (path2.size() == k) {
            res2.add(new LinkedList<>(path2));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path2.add(i);
            backtracking2(n, k, i + 1, res2, path2);
            path2.removeLast();
        }
    }
}

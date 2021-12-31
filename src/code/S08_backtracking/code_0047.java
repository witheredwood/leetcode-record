package code.S08_backtracking;

import java.util.*;

/**
 * 47.全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0047 {
    /**
     * 方案一：回溯（解决多层递归的问题） + 使用 list 存储符合条件的结果
     *
     * @param nums 一个序列，可包含重复数字
     * @return 所有不重复的全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        /** 符合条件的结果的集合，去重 */
        Set<List<Integer>> set = new HashSet<>();
        /** 符合条件的结果，存放的是数组中元素的下标 */
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(nums, set, path);
        List<List<Integer>> res = new LinkedList<>(set);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums 一个序列，可包含重复数字
     * @param set  符合条件的结果的集合，去重
     * @param path 符合条件的结果，存放的是数组中元素的下标
     */
    public void backtracking(int[] nums, Set<List<Integer>> set, LinkedList<Integer> path) {
        if (path.size() >= nums.length) {
            List<Integer> value = new ArrayList<>();
            for (int index : path) {
                value.add(nums[index]);
            }
            set.add(new ArrayList<>(value));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(i)) {
                path.add(i);
                backtracking(nums, set, path);
                path.removeLast();
            }
        }
    }

    /**
     * 方案二：回溯 + 使用 map 存储符合条件的结果
     *
     * @param nums 一个序列，可包含重复数字
     * @return 所有不重复的全排列
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        /** 符合条件的结果的集合，去重 */
        Set<List<Integer>> set = new HashSet<>();
        /** 符合条件的结果，存放的是数组中元素的下标 */
        Map<Integer, Integer> path = new LinkedHashMap<>();
        backtracking2(nums, set, path);
        List<List<Integer>> res = new LinkedList<>(set);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums 一个序列，可包含重复数字
     * @param set  符合条件的结果的集合，去重
     * @param path 符合条件的结果，key 是数组中元素的下标，value 是数组元素
     */
    public void backtracking2(int[] nums, Set<List<Integer>> set, Map<Integer, Integer> path) {
        if (path.size() >= nums.length) {
            set.add(new ArrayList<>(path.values()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path.containsKey(i)) {
                path.put(i, nums[i]);
                backtracking2(nums, set, path);
                path.remove(i);
            }
        }
    }
}

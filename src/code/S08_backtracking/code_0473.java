package code.S08_backtracking;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * <p>
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i个火柴棒的长度。
 * 你要用 所有的火柴棍拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 * 示例1:
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例2:
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 * <p>
 * 提示:
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 10^8
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0473 {

    /**
     * @param matchsticks 整数数组
     * @return 是否能用所有的火柴棍 拼成一个正方形
     */
    public boolean makesquare(int[] matchsticks) {
        // 数组总和
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        // 数组分成4组，每组数的和是 sum/4
        // 数组降序排列
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
        // 第一种方法
        boolean[] visited = new boolean[matchsticks.length];
        boolean[] memo = new boolean[matchsticks.length];
        visited[0] = true;
        return backtracking(matchsticks, 1, 1, matchsticks[0], sum / 4, visited, memo);
//        // 第二种方法
//        int[] bucket = new int[matchsticks.length];
//        bucket[0] = matchsticks[0];
//        return backtracking(matchsticks, 1, bucket, sum / 4);
    }

    /**
     * 回溯 + 剪枝
     * 方法一：把第 index 个火柴放入第 number 个集合，火柴从 startIndex 开始尝试放入
     * 耗时比第二种方法多
     *
     * @param nums        火柴，整数数组
     * @param startIndex  从第几个火柴开始
     * @param number      要放入火柴的第几个集合
     * @param curCapacity 当前正在放入火柴的集合的容量
     * @param capacity    每个集合的容量
     * @param visited     火柴是否已放入集合中
     * @return 是否能把所有的火柴放入集合中，并且每个集合的总和等于指定容量
     */
    private boolean backtracking(int[] nums, int startIndex, int number, int curCapacity, int capacity, boolean[] visited, boolean[] memo) {
        // 每一层是把一个火柴放进某个集合中，把所有的火柴放进集合里，回溯是 nums.length 层
        if (number == 4 && curCapacity == capacity) {
            // 是否把所有的火柴放入集合中
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) return false;
            }
            return true;
        }
        if (curCapacity == capacity) {  // 装满下一个集合
            return backtracking(nums, 0, number + 1, 0, capacity, visited, memo);
        }

        // 放入哪个火柴
        for (int i = startIndex; i < nums.length; i++) {  // 选择放入哪一集合中
            // 如果火柴放入集合中会超出集合的容量，则不放
            // 如果当前火柴已放入集合中，则不放
            if (visited[i]) continue;
            // 如果当前火柴放入集合中会超出集合的容量，则不放
            if (curCapacity + nums[i] > capacity) continue;
            // 当前火柴长度和上一个火柴相同，则不放入该桶中（因为该桶中放入过相同的值，并不合适）
            if (i > 0 && nums[i] == nums[i - 1] && memo[i - 1]) continue;
            // 当前集合的和和上一个集合的和一样，那么上一个集合放入不合适，这个集合放入也不合适
            visited[i] = true;      // 放入第 i 个火柴
            memo[i] = false;
            boolean res = backtracking(nums, startIndex + 1, number, curCapacity + nums[i], capacity, visited, memo);
            if (res) return res;
            memo[i] = true;
            visited[i] = false;        // 取出第 i 个火柴
        }
        return false;
    }

    /**
     * 回溯 + 剪枝
     * 方法二：把第 index 个火柴放在集合里
     *
     * @param nums     火柴，整数数组
     * @param index    把第几个火柴放入集合中
     * @param bucket   集合，整数数组，存放为该集合的总和
     * @param capacity 每个集合的容量
     * @return 是否能把所有的火柴放入集合中，并且每个集合的总和等于指定容量
     */
    private boolean backtracking(int[] nums, int index, int[] bucket, int capacity) {
        // 每一层是把一个火柴放进某个集合中，把所有的火柴放进集合里，回溯是 nums.length 层
        if (index == nums.length) {
            for (int i = 0; i < 4; i++) {
                if (bucket[i] != capacity) return false;
            }
            return true;
        }

        // 把第 index 个火柴放入哪个集合里
        for (int i = 0; i < 4; i++) {  // 选择放入哪一集合中
            // 如果火柴放入集合中会超出集合的容量，则不放
            if (bucket[i] + nums[index] > capacity) continue;
            // 当前集合的和和上一个集合的和一样，那么上一个集合放入不合适，这个集合放入也不合适
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;

            bucket[i] += nums[index];       // 放入第 i 个集合中
            boolean res = backtracking(nums, index + 1, bucket, capacity);      // 把第 index 个火柴放入集合中
            if (res) return res;
            bucket[i] -= nums[index];        // 从第 i 个集合中取出第 index 个火柴
        }
        return false;
    }
}

package code.S02_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 18. 四数之和
 * <p>
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0018 {
  /**
   * 本题注意溢出
   * int 的最大值约 2.1*10^9
   * long 的最大值约  9.2*10^12
   * 两数相加，结果的类型是两数中范围最大的类型
   * */

  /**
   * @param nums   数组
   * @param target 目标值
   * @return 数组中相加等于目标值的四个数的集合
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    Set<List<Integer>> resultSet = new HashSet<>();
    // 固定a，遇重复值跳过
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      // 固定b，遇重复值跳过
      for (int j = i + 1; j < nums.length; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        long tmpTarget = (long) target - nums[i] - nums[j];
        for (int m = j + 1, n = nums.length - 1; m < n; ) {
          if (tmpTarget == nums[m] + nums[n]) {
            Integer[] elementArray = new Integer[]{nums[i], nums[j], nums[m], nums[n]};
            // 数组转List
            // 方式一：
//            List<Integer> elementList = new ArrayList<>();
//            Collections.addAll(elementList, elementArray);
            // 方式二：
            List<Integer> elementList = new ArrayList<>(Arrays.asList(elementArray));
            resultSet.add(elementList);
            m++;
            n--;
          } else if (tmpTarget < nums[m] + nums[n]) {
            n--;
          } else {
            m++;
          }
        }
      }
    }
    return new ArrayList<>(resultSet);
  }
}

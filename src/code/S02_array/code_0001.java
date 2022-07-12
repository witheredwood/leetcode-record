package code.S01_bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0001 {
  /**
   * 暴力解法：两次遍历
   * time: O(n^2);  space: O(1)
   *
   * @param nums   数组
   * @param target 目标值
   * @return 数组中等于目标值 target 的两个数的下标
   */
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (target == nums[i] + nums[j]) {
          result[0] = i;
          result[1] = j;
          break;
        }
      }
      if (result[0] != result[1]) break;
    }
    return result;
  }

  /**
   * 以空间space时间time。
   * 如果数组是有序的，那么只遍历一次就可以得到两个数的下标。然而不能对数组排序，否则就不知道初始下标了。
   * 所以将数组转为hash，对哈希排序，然后遍历查找。
   * time: O(nlogn);  space: O(n)
   *
   * @param nums   数组
   * @param target 目标值
   * @return 数组中等于目标值 target 的两个数的下标
   */
  public int[] twoSum2(int[] nums, int target) {
   // 转为hash
    Map<Integer, Integer> hashmap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      hashmap.put(i, nums[i]);
    }
    // 对hash排序（实际是转化后的list排序），升序
    Set<Map.Entry<Integer, Integer>> set = hashmap.entrySet();
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
    Collections.sort(list, (a, b) -> {
      return a.getValue() - b.getValue();
    });
    int[] result = new int[2];
    for (int i = 0, j = list.size() - 1; i < j;) {
      int sum = list.get(i).getValue() + list.get(j).getValue();
      if (target == sum) {
        result[0] = list.get(i).getKey();
        result[1] = list.get(j).getKey();
        break;
      } else if (target < sum) {
        j--;
      } else {
        i++;
      }
    }
    return result;
  }
}

package code.S02_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0015 {
  /**
   * 超出时间限制
   * time: O(n^2)   space: O(1)
   *
   * @param nums 数组
   * @return 数组中三个数相加为0的三个数
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> resultSet = new HashSet<>();
    // 固定c
    for (int i = 0; i < nums.length; i++) {
      // 双指针
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        if (-nums[i] == nums[j] + nums[k]) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          resultSet.add(list);
          j++;
          k--;
        } else if (-nums[i] < nums[j] + nums[k]) {
          k--;
        } else {
          j++;
        }
      }
    }
    return new ArrayList<>(resultSet);
  }
}

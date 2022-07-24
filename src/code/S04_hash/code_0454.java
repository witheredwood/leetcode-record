package code.S04_hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * <p>
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * <p>
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0454 {
  /**
   * time: O(n^2);    space: O(n)
   *
   * @param nums1 整数数组
   * @param nums2 整数数组
   * @param nums3 整数数组
   * @param nums4 整数数组
   * @return 等于0的方案有几种
   */
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    // 统计 nums1+num2、nums3+num4 中的和
    Map<Integer, Integer> map1 = getSum(nums1, nums2);
    Map<Integer, Integer> map2 = getSum(nums3, nums4);
    // 统计个数
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
      if (map2.containsKey(-entry.getKey())) {
        count += entry.getValue() * map2.get(-entry.getKey());
      }
    }
    return count;
  }

  /**
   * time: O(n^2);    space: O(n)
   *
   * @param nums1 整数数组
   * @param nums2 整数数组
   * @return 两个数组相加后的和的个数
   */
  private Map<Integer, Integer> getSum(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        int sum = nums1[i] + nums2[j];
        if (!map.containsKey(sum)) {
          map.put(sum, 1);
        } else {
          map.replace(sum, map.get(sum) + 1);
        }
      }
    }
    return map;
  }
}

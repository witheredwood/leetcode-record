package code.S04_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * <p>
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0350 {
  /**
   * time: O(n+m);    space: O(n+m)
   *
   * @param nums1 数组
   * @param nums2 数组
   * @return 两个数组的交集
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    // 存储两个数组中每个元素的个数
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      if (!map1.containsKey(nums1[i])) {
        map1.put(nums1[i], 1);
      } else {
        map1.replace(nums1[i], map1.get(nums1[i]) + 1);
      }
    }
    for (int i = 0; i < nums2.length; i++) {
      if (!map2.containsKey(nums2[i])) {
        map2.put(nums2[i], 1);
      } else {
        map2.replace(nums2[i], map2.get(nums2[i]) + 1);
      }
    }
    // 求并集
    List<Integer> resultList = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
      if (map2.containsKey(entry.getKey())) {
        int num = Math.min(entry.getValue(), map2.get(entry.getKey()));
        for (int i = 0; i < num; i++) {
          resultList.add(entry.getKey());
        }
      }
    }
    Integer[] result = resultList.toArray(new Integer[0]);
    return Arrays.stream(result).mapToInt(Integer::valueOf).toArray();
  }
}

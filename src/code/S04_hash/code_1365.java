package code.S04_hash;

import java.util.*;

/**
 * 1365. 有多少小于当前数字的数字
 * <p>
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 * 以数组形式返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1365 {
  /**
   * 转化为哈希表进行排序，同时保留各元素的下标
   * time: O(nlogn);    space: O(n)
   *
   * @param nums 给定的数组
   * @return 统计数组中每个数字比它小的所有数字的数目
   */
  public int[] smallerNumbersThanCurrent31(int[] nums) {
    // 构建哈希表
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(i, nums[i]);
    }
    // 排序
    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
    Collections.sort(entryList, (a, b) -> {
      if (a.getValue() != b.getValue()) return a.getValue() - b.getValue();
      return a.getKey() - b.getKey();
    });
    // 统计
    int[] count = new int[nums.length];
    for (int i = 1; i < entryList.size(); i++) {
      Map.Entry<Integer, Integer> curEntry = entryList.get(i);
      Map.Entry<Integer, Integer> preEntry = entryList.get(i - 1);
      if (curEntry.getValue() > preEntry.getValue()) {
        count[curEntry.getKey()] = i;
      } else {
        count[curEntry.getKey()] = count[preEntry.getKey()];
      }
    }
    return count;
  }

  /**
   * 双重循环。时间复杂度 O（n^2），空间复杂度 O（n）
   *
   * @param nums 给定的数组
   * @return 统计数组中每个数字比它小的所有数字的数目
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (nums[i] > nums[j]) res[i]++;
      }
    }
    System.out.println("res = " + Arrays.toString(res));
    return res;
  }

  /**
   * 哈希+排序。时间复杂度 O（2n+nlogn），空间复杂度 O（3n）
   *
   * @param nums 给定的数组
   * @return 统计数组中每个数字比它小的所有数字的数目
   */
  public int[] smallerNumbersThanCurrent2(int[] nums) {
    int len = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      map.put(i, nums[i]);
    }
    // map 按值排序
    List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue() - o2.getValue();  // 升序
      }
    });
    Map<Integer, Integer> sortedMap = new HashMap<>();
    for (int i = 0; i < len; i++) {
      if (i == 0 || !list.get(i).getValue().equals(list.get(i - 1).getValue())) {
        sortedMap.put(list.get(i).getKey(), i);
      } else {
        sortedMap.put(list.get(i).getKey(), sortedMap.get(list.get(i - 1).getKey()));
      }
    }
    System.out.println("list = " + list);
    System.out.println("map = " + sortedMap);
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      res[i] = sortedMap.get(i);
    }
    System.out.println("res = " + Arrays.toString(res));
    return res;
  }


}

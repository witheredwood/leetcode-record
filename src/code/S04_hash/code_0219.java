package code.S04_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code_0219 {

  /**
   * time: O(n);    space: O(n)
   *
   * @param nums 整数数组
   * @param k    整数
   * @return 是否存在重复的元素，它们的索引间距不大 于 k
   */
  public boolean containsNearbyDuplicate32(int[] nums, int k) {
    // 存储每个值的下标，每个值的的下标是升序排列
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], new ArrayList<>(Arrays.asList(new Integer[]{i})));
      } else {
        map.get(nums[i]).add(i);
      }
    }
    // 逐一排查
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      if (entry.getValue().size() > 1) {
        List<Integer> entryElement = entry.getValue();
        for (int i = 1; i < entryElement.size(); i++) {
          if (entryElement.get(i) - entryElement.get(i - 1) <= k) return true;
        }
      }
    }
    return false;
  }

  /**
   * time: O(nlogn);    space: O(n)
   *
   * @param nums 整数数组
   * @param k    整数
   * @return 是否存在重复的元素，它们的索引间距不大 于 k
   */
  public boolean containsNearbyDuplicate31(int[] nums, int k) {
    // 使用 hashmap 存储index
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
    // 逐一排查
    for (int i = 1; i < entryList.size(); i++) {
      Map.Entry<Integer, Integer> preEntry = entryList.get(i -1);
      Map.Entry<Integer, Integer> curEntry = entryList.get(i);
      if (curEntry.getValue() == preEntry.getValue() && curEntry.getKey() - preEntry.getKey() <= k) {
        return true;
      }
    }
    return false;
  }

}

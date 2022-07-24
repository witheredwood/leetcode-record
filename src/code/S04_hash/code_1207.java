package code.S04_hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 1207. 独一无二的出现次数
 * <p>
 * 给你一个整数数组arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= arr.length<= 1000
 * -1000 <= arr[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1207 {
  /**
   * time: O(n);        space: O(n)
   *
   * @param arr 整数数组
   * @return 数组中每个数的出现次数是否是独一无二的
   */
  public boolean uniqueOccurrences32(int[] arr) {
    // 统计数组中每个数出现的次数
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i])) {
        map.put(arr[i], 1);
      } else {
        map.replace(arr[i], map.get(arr[i]) + 1);
      }
    }
    // 检查出现的次数是否是独一无二的
    Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Integer, Integer> entry = it.next();
      it.remove();
      if (map.containsValue(entry.getValue())) return false;
    }
    return true;
  }

  /**
   * time: O(nlogn);        space: O(n)
   *
   * @param arr 整数数组
   * @return 数组中每个数的出现次数是否是独一无二的
   */
  public boolean uniqueOccurrences(int[] arr) {
    // 统计数组中每个数出现的次数
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i])) {
        map.put(arr[i], 1);
      } else {
        map.replace(arr[i], map.get(arr[i]) + 1);
      }
    }
    // 检查出现的次数是否是独一无二的
    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
    Collections.sort(entryList, (a, b) -> {
      if (a.getValue() != b.getValue()) return a.getValue() - b.getValue();
      return a.getKey() - b.getKey();
    });
    for (int i = 1; i < entryList.size(); i++) {
      if (entryList.get(i).getValue() == entryList.get(i - 1).getValue()) return false;
    }
    return true;
  }
}

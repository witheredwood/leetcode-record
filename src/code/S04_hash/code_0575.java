package code.S04_hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 575. 分糖果
 * <p>
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。
 * Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。
 * <p>
 * 示例 1：
 * 输入：candyType = [1,1,2,2,3,3]
 * 输出：3
 * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
 * 示例 2：
 * 输入：candyType = [1,1,2,3]
 * 输出：2
 * 解释：Alice 只能吃 4 / 2 = 2 枚糖，不管她选择吃的种类是 [1,2]、[1,3] 还是 [2,3]，她只能吃到两种不同类的糖。
 * 示例 3：
 * 输入：candyType = [6,6,6,6]
 * 输出：1
 * 解释：Alice 只能吃 4 / 2 = 2 枚糖，尽管她能吃 2 枚，但只能吃到 1 种糖。
 * <p>
 * 提示：
 * n == candyType.length
 * 2 <= n <= 10^4
 * n 是一个偶数
 * -10^5 <= candyType[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0575 {
  /**
   * time: O(n);      space: O(n)
   *
   * @param candyType 整数数组
   * @return 吃到的糖的种类
   */
  public int distributeCandies(int[] candyType) {
    // 获取糖果的种类
    Set<Integer> type = new HashSet<>();
    for (int i = 0; i < candyType.length; i++) {
      if (!type.contains(candyType[i])) {
        type.add(candyType[i]);
      }
    }
    // 吃到的糖果种类= Math.min(种类数，吃到的糖果数)
    return Math.min(type.size(), candyType.length / 2);
  }
}

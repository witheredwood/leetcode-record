package code.S02_array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 56. 合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0056 {
  /**
   * 区间按照左端点非降序排列，然后遍历各区间，合并重叠的区间
   * time: O(nlogn);   space: O(n)
   *
   * @param intervals 二维数组
   * @return 合并重叠区间后的二维数组
   */
  public int[][] merge(int[][] intervals) {
    // 对二维数组排序
    Arrays.sort(intervals, (a, b) -> {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    });
    // 合并区间
    ArrayList<int[]> resultList = new ArrayList<>();
    resultList.add(intervals[0]);  // 初始化
    for (int i = 1; i < intervals.length; i++) {
      int[] pre = resultList.get(resultList.size() - 1);
      if (intervals[i][0] <= pre[1]) {
        pre[1] = Math.max(intervals[i][1], pre[1]);
      } else {
        resultList.add(intervals[i]);
      }
    }
    return resultList.toArray(new int[0][0]);
  }
}

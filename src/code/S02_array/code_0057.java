package code.S02_array;

import java.text.CollationKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 57.插入区间
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0057 {

  /**
   * 找到和新区间有重叠部分的左右两个区间，在最后的区间链表中分别加入重叠部分左边的区间、重叠部分合并后的区间、重叠部分右边的区间。
   * 若所有区间和新区间均无重叠，则找到新区间插入的位置。
   * 这个代码现在的样子，是第一次测试样例通过之后，又经过几次的美化及简化，时间和空间并不会增加，但自我感觉现在的代码好看了不少
   * time: O(n);   space: O(n)
   *
   * @param intervals   区间，二维数组存储
   * @param newInterval 插入的新区建
   * @return 插入后的结果
   */
  public int[][] insert32(int[][] intervals, int[] newInterval) {
    List<int[]> resultList = new ArrayList<>();  // 存放插入新区间后的所有区间
    int left = 0, right;  // 与新区间有重叠的区间的左右区间的下标
    // 寻找与新区间重叠的左区间的下标。从左向右遍历区间，若当前区间和新区间无重叠，则遍历下一个
    while (left < intervals.length && (intervals[left][0] > newInterval[1] || intervals[left][1] < newInterval[0]))
      left++;
    if (left < intervals.length) {  // 有重叠
      right = intervals.length - 1;
      // 寻找与新区间重叠的右区间的下标。从右向左遍历区间，若当前区间和新区间无重叠，则遍历下一个
      while (right >= 0 && (intervals[right][0] > newInterval[1] || intervals[right][1] < newInterval[0]))
        right--;
      // 得到最后的区间链表
      Collections.addAll(resultList, Arrays.copyOfRange(intervals, 0, left));
      resultList.add(new int[]{Math.min(intervals[left][0], newInterval[0]), Math.max(intervals[right][1], newInterval[1])});
      Collections.addAll(resultList, Arrays.copyOfRange(intervals, right + 1, intervals.length));
    } else {  // 无重叠
      Collections.addAll(resultList, intervals);
      int index = 0;  // 新区间要插入的位置
      while (index < intervals.length && newInterval[0] >= intervals[index][1]) index++;
      resultList.add(index, newInterval);
    }
    return resultList.toArray(new int[0][0]);
  }

  /**
   * 插入新区间后，对插入后的区间进行升序排序，之后再合并重叠的区间。
   * time: O(nlogn);   space: O(n)
   *
   * @param intervals   区间，二维数组存储
   * @param newInterval 插入的新区建
   * @return 插入后的结果
   */
  public int[][] insert31(int[][] intervals, int[] newInterval) {
    // 插入新区间
    List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
    intervalsList.add(newInterval);
    // 排序
    Collections.sort(intervalsList, (a, b) -> {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    });
    // 合并区间
    List<int[]> resultList = new ArrayList<>();
    resultList.add(intervalsList.get(0));
    for (int i = 1; i < intervalsList.size(); i++) {
      int[] pre = resultList.get(resultList.size() - 1);
      int[] cur = intervalsList.get(i);
      if (cur[0] <= pre[1]) {
        pre[1] = Math.max(cur[1], pre[1]);
      } else {
        resultList.add(cur);
      }
    }
    return resultList.toArray(new int[0][0]);
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int len = intervals.length;
    if (len == 0)
      return new int[][]{newInterval};
    List<int[]> list = new LinkedList<>();
    int index = 0;
    while (index < len) {
      if (intervals[index][1] < newInterval[0]) {
        list.add(intervals[index++]);
      } else if (intervals[index][0] > newInterval[1]) {
        break;
      } else {
        // 处理重叠部分。比较 newInterval 和当前的数组 intervals[i]
        newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
        index++;
      }
    }
    list.add(newInterval);
    while (index < len)
      list.add(intervals[index++]);
    int[][] res = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      res[i][0] = list.get(i)[0];
      res[i][1] = list.get(i)[1];
    }
    System.out.println("res = " + Arrays.deepToString(res));
    return res;
  }
}

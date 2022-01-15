package code.S09_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 435. 无重叠区间
 * <p>
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0435 {
    /**
     * 排序+遍历。排序后移除有交集区间中长度较长的区间
     * 时间复杂度 O(nlogn + n)，空间复杂度 O(n)
     *
     * @param intervals 区间的整数数组
     * @return 移除几个区间后数组无重叠
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按左边界升序。返回值：1 / -1 / 0
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] < b[0] ? -1 : 1;
            if (a[1] == b[1]) return 0;
            return a[1] < b[1] ? -1 : 1;
        });
        System.out.println("sort = " + Arrays.deepToString(intervals));
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        System.out.println("list = " + Arrays.deepToString(list.toArray()));
        Iterator<int[]> it = list.iterator();
        int[] pre = it.next();  // 初始化，获取第一个值
        while (it.hasNext()) {
            int[] cur = it.next();
            if (cur[0] == pre[0]) {  // 和上一个区间起点相同，或有重叠
                it.remove();
            } else if (cur[0] < pre[1]) {  // 有重叠，删除右区间最大的那个区间
                if (cur[1] < pre[1]) {  // 删除上一个区间
                    pre[0] = cur[0];
                    pre[1] = cur[1];
                }
                it.remove();
            } else {
                pre = cur;
            }
        }
        System.out.println("list = " + Arrays.deepToString(list.toArray()));
        return intervals.length - list.size();
    }

    /**
     * 排序+遍历。排序后选择右边界最小的区间。右边界是判断两个区间是否重叠比较重要的因素
     * 时间复杂度 O(nlogn + n)，空间复杂度 O(1)
     *
     * @param intervals 区间的整数数组
     * @return 移除几个区间后数组无重叠
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        // 按右边界升序，右边界相同，按左边界降序。返回值：1 / -1 / 0
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] < b[1] ? -1 : 1;
            if (a[0] == b[0]) return 0;
            return a[0] < b[0] ? 1 : -1;
        });
        System.out.println("sort = " + Arrays.deepToString(intervals));
        // 记录当前的右边界以及不重叠区间的个数
        int count = 0, right = Integer.MIN_VALUE;
        for (int[] point: intervals) {
            // 两个区间没有交集
            if (right <= point[0]){
                count++;
                right = point[1];
                System.out.println("arr = " + Arrays.toString(point));
            }
        }
        System.out.println("count = " + count);
        return intervals.length - count;
    }
}

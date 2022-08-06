package code.S09_greedy;

import java.util.*;

/**
 * 452. 用最少数量的箭引爆气球
 * <p>
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为
 * xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
 * 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= points.length <= 10^4
 * points[i].length == 2
 * -2^31 <= xstart <xend <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0452 {
    /**
     * time: O(nlogn);      space: O(1)
     *
     * @param points 区间数组，整数
     * @return 所需的最小弓箭数
     */
    public int findMinArrowShots31(int[][] points) {
        // 排序
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] < b[0] ? -1 : 1;
            return a[1] < b[1] ? -1 : 1;
        });
        // 统计
        int count = 1;
        int[] last = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] cur = points[i];
            // 有重叠，找交集
            if (cur[0] <= last[1]) {
                last[0] = Math.max(last[0], cur[0]);
                last[1] = Math.min(cur[1], last[1]);
            } else {       // 无重叠
                count++;
                last = cur;
            }
        }
        return count;
    }

    /**
     * 时间复杂度 o(nlogn + n)，空间复杂度 O(size)
     *
     * @param points 区间数组，整数
     * @return 所需的最小弓箭数
     */
    public int findMinArrowShots(int[][] points) {
        // 升序。不用 a-b 的原因是，如果出现负数，减之后的结果会越界，导致结果错误
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] < b[0] ? -1 : 1;
            return a[1] < b[1] ? -1 : 1;
        });
        System.out.println("points = " + Arrays.deepToString(points));
        List<int[]> list = new ArrayList<>();
        for (int[] point : points) {
            if (list.size() == 0) {
                list.add(0, point);
                continue;
            }
            int[] first = list.get(0);
            if (point[0] <= first[1]) {  // 有交集
                int[] tmp = {Math.max(point[0], first[0]), Math.min(point[1], first[1])};
                list.remove(0);
                list.add(0, tmp);
            } else {  // 无交集
                list.add(0, point);
            }
        }
        Arrays.deepToString(list.toArray());
        return list.size();
    }
}

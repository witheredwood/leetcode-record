package code.S06_stack_queue;

import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 * <p>
 * 给定一个数组 points，其中points[i] = [xi, yi]表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 * 这里，平面上两点之间的距离是欧几里德距离（√(x1- x2)^2+ (y1- y2)^2）。
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 * <p>
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], k = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * <p>
 * 提示：
 * 1 <= k <= points.length <= 10^4
 * -10^4 < xi, yi < 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0973 {
    /**
     * 优先级队列
     * time: O(nlogn);      space: O(n)
     *
     * @param points 数组
     * @param k      整数
     * @return 离原点 (0,0) 最近的 k 个点
     */
    public int[][] kClosest(int[][] points, int k) {
        // 定义优先级队列，并降序排列
        PriorityQueue<int[]> queue = new PriorityQueue<>((point1, point2) -> {
            int a = point1[0] * point1[0] + point1[1] * point1[1];
            int b = point2[0] * point2[0] + point2[1] * point2[1];
            return b - a;
        });
        // 遍历
        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (queue.size() > k) queue.poll();
        }
        return queue.toArray(new int[0][0]);
    }
}

package code.S02_array;

import java.util.LinkedList;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0042 {
    /**
     * @param height 每个宽度为 1 的柱子的高度数组
     * @return 能接的雨水的量
     */
    public int trap(int[] height) {
        int sum = 0;
        LinkedList<Integer> stack = new LinkedList<>();  // 栈中存放的是下标
        int len = height.length;
        for (int i = 0; i < len; i++) {
            int current = height[i];
            while (stack.size() > 0 && height[i] > height[stack.getFirst()]) {
                if (stack.size() < 2) {
                    while (stack.size() > 0) {
                        stack.removeFirst();
                    }
                } else {
                    // 从栈中弹出两个数
                    int rightIndex = stack.removeFirst();
                    int leftIndex = stack.removeFirst();
                    sum += (i - leftIndex - 1) * (Math.min(height[i], height[leftIndex]) - height[rightIndex]);  // 计算面积：宽*高
                    // 压入新的最高高度的下标
                    stack.addFirst(height[leftIndex] >= height[rightIndex] ? leftIndex : rightIndex);
                }
            }
            stack.addFirst(i);
            System.out.println("stack = " + stack.toString() + " sum = " + sum);
        }
        return sum;
    }
}

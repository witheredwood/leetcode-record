package code.S06_stack_queue;

import java.util.LinkedList;

public class code_0084 {
    /**
     * 以空间换时间，存储左边的宽度
     * time: O(n);        space: O(n)
     *
     * @param heights 整数数组
     * @return 最大面积
     */
    public int largestRectangleArea32(int[] heights) {
        int result = -1;  // 最大面积
        LinkedList<Integer> stack = new LinkedList<>();  // 栈中存放单调递增的数据
        for (int i = 0; i <= heights.length; i++) {
            // 当栈不空，并且当前值小于栈顶值 or 遍历到数组结尾
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int index = stack.pop();  // 高度的下标值
                int left = stack.isEmpty() ? -1 : stack.peek();  // 宽度的左下标
                int area = heights[index] * (i - left - 1);  // 可以确定的以 index 为高度的最大的面积值
                result = Math.max(area, result);
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 对于当前高度，向左右两边扩散，找到最大宽度
     * time: O(n^2);        space: O(1)
     * 超出时间限制
     *
     * @param heights 整数数组
     * @return 最大面积
     */
    public int largestRectangleArea31(int[] heights) {
        int index = 0;
        int result = -1;
        while (index < heights.length) {
            // 向左找下降点
            int left = index - 1;
            while (left >= 0 && heights[index] <= heights[left]) left--;
            // 向右找下降点
            int right = index + 1;
            while (right < heights.length && heights[index] <= heights[right]) right++;
            int width = right - left - 1;  // 宽
            int area = width * heights[index];   // 面积
            result = Math.max(area, result);
            index++;
        }
        return result;
    }
}

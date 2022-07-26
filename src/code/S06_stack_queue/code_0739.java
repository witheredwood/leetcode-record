package code.S06_stack_queue;

import java.util.LinkedList;

/**
 * 739. 每日温度
 * <p>
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
 * 其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * 1 <=temperatures.length <= 10^5
 * 30 <=temperatures[i]<= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0739 {
    /**
     * 单调栈
     * time: O(n);        space: O(n)
     *
     * @param temperatures 整数数组
     * @return 一个数组
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}

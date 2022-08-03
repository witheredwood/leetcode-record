package code.S09_greedy;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * <p>
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 示例1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * 示例3：
 * 输入：ratings = [1,3,2,2,1]
 * 输出：7
 * <p>
 * 提示：
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0135 {
    /**
     * time: O(n);      space: O(n)
     *
     * @param ratings 整数数组，存放的元素的每个孩子的评分
     * @return 分配的最少糖果个数
     */
    public int candy31(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;
        // 从左到右给糖，评分高的比左边相邻的多一颗糖
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) count[i] = count[i - 1] + 1;
            else count[i] = 1;
        }
        // 从右到左，调整评分高的比右边相邻低的
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && count[i] <= count[i + 1])
                count[i] = count[i + 1] + 1;
        }
        // 计算总数
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            result += count[i];
        }
        return result;
    }

    /**
     * @param ratings 整数数组，存放的元素的每个孩子的评分
     * @return 分配的最少糖果个数
     */
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                count[i] = Math.max(count[i], count[i - 1] + 1);
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                count[i] = Math.max(count[i], count[i + 1] + 1);
        }
        System.out.println("count = " + Arrays.toString(count));
        // 计算糖果数
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            num += count[i];
        }
        num += ratings.length;
        System.out.println("num = " + num);
        return num;
    }
}

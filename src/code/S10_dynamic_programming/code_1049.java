package code.S10_dynamic_programming;

/**
 * 1049. 最后一块石头的重量 II
 * <p>
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 * 输入：stones = [1,2]
 * 输出：1
 *  
 * <p>
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1049 {
    /**
     * 动态规划：0-1 背包问题
     * 将数组分成两个子集，使其总和之差尽可能的小，也就是尽可能总和接近总重量的一半
     * 时间复杂度 O(n*m)，空间复杂度 O(n*m). m：数组长度；n：重量总和的一半
     *
     * @param stones 石头重量数组
     * @return 粉碎后剩余的最小重量
     */
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int weight = 0;
        for (int i = 0; i < len; i++) {
            weight += stones[i];
        }
        int biweight = weight >> 1;  // 总重量的一半
        int[][] dp = new int[len][biweight + 1];
        // 初始化
        for (int i = stones[0]; i <= biweight; i++) {
            dp[0][i] = stones[0];
        }
        // 遍历求解
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= biweight; j++) {
                if (stones[i] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
            }
        }

        return weight - dp[len - 1][biweight] * 2;
    }

    /**
     * 动态规划：0-1 背包问题
     * 将数组分成两个子集，使其总和之差尽可能的小，也就是尽可能总和接近总重量的一半
     * 时间复杂度 O(n*m)，空间复杂度 O(n)。m：数组长度；n：重量总和的一半
     *
     * @param stones 石头重量数组
     * @return 粉碎后剩余的最小重量
     */
    public int lastStoneWeightII2(int[] stones) {
        int weight = 0;
        for (int s : stones) {
            weight += s;
        }
        int biweight = weight >> 1;  // 总重量的一半
        int[] dp = new int[biweight + 1];
        // 初始化
        for (int i = stones[0]; i <= biweight; i++) {
            dp[i] = stones[0];
        }
        // 遍历求解
        for (int i = 1; i < stones.length; i++) {
            for (int j = biweight; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], stones[i] + dp[j - stones[i]]);
            }
        }
        return weight - dp[biweight] * 2;
    }

}

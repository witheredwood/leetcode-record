package code.S09_greedy;

/**
 * 122.买卖股票的最佳时机II
 * <p>
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
 * 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，
 * 你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: prices = [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 提示：
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0122 {
    /**
     * 贪心：当前的状态和利润和以前的状态无关
     * 卖出则买入
     * time: O(n);      space: O(1)
     *
     * @param prices 整数数组
     * @return 最大利润
     */
    public int maxProfit31(int[] prices) {
        int buy = prices[0];    // 初始买入第一天的股票
        int profit = 0;  // 初始利润为0 = sell - buy
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {  // 重新买入
                buy = prices[i];
            } else if (prices[i] > buy) {      // 有利润则卖出
                profit += prices[i] - buy;     // 计算当天卖出的利润
                buy = prices[i];     // 买入当天的股票
            }
        }
        return profit;
    }

    /**
     * @param prices 正整数数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];  // 初始化买入价格
        int sell = buy;  // 初始化卖出价格
        int profit = 0;  // 初始时利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > sell) {  // 当前时刻比之前卖出的价格高，重新卖出，之前卖的不算
                profit += prices[i] - sell;
                sell = prices[i];
            } else if (prices[i] < sell) {  // 当前时刻比之前卖出的价格低，买入
                buy = prices[i];
                sell = buy;  // 每次买入初始化卖出价格，不能停留在上次卖出的价格
            }
        }
        System.out.println("profit = " + profit);
        return profit;
    }

    /**
     * 贪心：把利润分解为每天的利润相加
     * 局部最优：收集每天的正利润，全局最优：求得最大利润
     *
     * @param prices 正整数数组
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;  // 初始时利润
        for (int i = 1; i < prices.length; i++) {
            int pro = prices[i] - prices[i - 1];  // 计算当天卖出的利润
            if (pro > 0) {  // 利润为正
                profit += pro;
            }
        }
        System.out.println("profit = " + profit);
        return profit;
    }
}

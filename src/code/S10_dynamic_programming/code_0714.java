package code.S10_dynamic_programming;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1：
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * <p>
 * 提示：
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0714 {
    /**
     * 贪心。目标：如何获得最大收益
     * 当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利
     *
     * @param prices 某段时间内的股票价格
     * @param fee    每次交易的手续费
     * @return 该段时间内的最大利润
     */
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;  // 手中已有的买入的价格，先买入第0天的股票
        int profits = 0;  // 利润
        for (int i = 1; i < prices.length; i++) {  // 一个循环找到一次买入和卖出
            // 当前的股票价格（加上手续费）小于手中股票的买入价格，则以更低价格买入，放弃之前的价格
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;  // 重新买入
            } else if (prices[i] > buy) {  // 卖出
                profits += prices[i] - buy;
                buy = prices[i];  // 更新卖入价格
            }
            System.out.println("prices = " + prices[i] + "  buy = " + (buy - fee) + "  profits = " + profits);
        }
        return profits;
    }

    /**
     * 动态规划
     *
     * @param prices 某段时间内的股票价格
     * @param fee    每次交易的手续费
     * @return 该段时间内的最大利润
     */
    public int maxProfit2(int[] prices, int fee) {
        int profits = 0;  // 利润
        return profits;
    }
}

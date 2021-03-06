package code.S09_greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
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
 */
class code_0122Test extends code_0122 {
    int[] prices1 = {7, 1, 5, 3, 6, 4};
    int expected1 = 7;

    int[] prices2 = {1, 2, 3, 4, 5};
    int expected2 = 4;

    int[] prices3 = {7, 6, 4, 3, 1};
    int expected3 = 0;

    @Test
    void testMaxProfit() {
        Assertions.assertEquals(expected1, maxProfit(prices1));
        System.out.println("-------------------------");
        Assertions.assertEquals(expected2, maxProfit(prices2));
        System.out.println("-------------------------");
        Assertions.assertEquals(expected3, maxProfit(prices3));
    }

    @Test
    void testMaxProfit2() {
        Assertions.assertEquals(expected1, maxProfit2(prices1));
        System.out.println("-------------------------");
        Assertions.assertEquals(expected2, maxProfit2(prices2));
        System.out.println("-------------------------");
        Assertions.assertEquals(expected3, maxProfit2(prices3));
    }
}

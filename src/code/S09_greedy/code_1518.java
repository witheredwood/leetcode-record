package code.S09_greedy;

/**
 * 1518. 换酒问题
 * <p>
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 * <p>
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 * 示例 3：
 * 输入：numBottles = 5, numExchange = 5
 * 输出：6
 * 示例 4：
 * 输入：numBottles = 2, numExchange = 3
 * 输出：2
 * <p>
 * 提示：
 * 1 <=numBottles <= 100
 * 2 <=numExchange <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1518 {
    /**
     * @param numBottles  整数，酒数量
     * @param numExchange 整数，能换一瓶酒的空酒瓶数量
     * @return 一共能喝几瓶就
     */
    public int numWaterBottles31(int numBottles, int numExchange) {
        int count = 0;      // 喝的酒总量
        int emptyBottles = 0;       // 空瓶数量
        while (numBottles + emptyBottles >= numExchange) {
            count += numBottles;    // 喝掉现在所有的酒
            int exchangeBottle = (numBottles + emptyBottles) / numExchange;   // 能换到几瓶酒
            emptyBottles = (numBottles + emptyBottles) % numExchange;       // 剩余几个空瓶
            numBottles = exchangeBottle;        // 新的酒个数
        }
        count += numBottles;    // 喝掉剩余的酒
        return count;
    }
}

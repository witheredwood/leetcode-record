package code.S10_dynamic_programming;

/**
 * 486. 预测赢家
 * <p>
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），
 * 取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。
 * 当数组中没有剩余数字可取时，游戏结束。
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,2]
 * 输出：false
 * 解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 false 。
 * 示例 2：
 * 输入：nums = [1,5,233,7]
 * 输出：true
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。
 * <p>
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0486 {
    /**
     * 最优的策略，就是每次选择的分数，会最有利于自己。对方选择的最优得分+自己选择的分数后的最优值
     */

    /**
     * 方法3：动态规划
     * 从递归树上看，记忆化递归时从上到下的过程，动态规划是从下到上的过程。
     * 记忆化递归是从上到下递归时，顺便记录递归结果，方便下次遇到同样的递归时不需要进行重复的计算。
     * 动态规划是先把各个小问题的结果（递归结果）求解出来，然后从递归结果中得到大问题的结果
     *
     * @param nums 整型数组
     * @return 第一个玩家是不是赢家，第1个玩家的分数大于等于第2个玩家时赢
     */
    public boolean PredictTheWinner33(int[] nums) {
        int play = nums.length % 2 == 0 ? -1 : 1;   // play = 1 时，表示是己方在做选择；play = -1时，表示是对方在做选择。
        int[][] relative = new int[nums.length][nums.length];
        // 初始化
        for (int i = nums.length - 1; i >= 0; i--) {
            relative[i][i] = play * nums[i];
        }
        play = -play;
        for (int k = 1; k < nums.length; k++) {
            for (int i = nums.length - k - 1, j = i + k; i >= 0; i--, j--) {
                // 如果是己方，己方分数是正，选择的分数+相对得分
                if (play == 1) {
                    relative[i][j] = Math.max(play * nums[i] + relative[i + 1][j], play * nums[j] + relative[i][j - 1]);
                } else {     // 如果是对方，对方分数是负，-选择的分数+相对得分
                    relative[i][j] = Math.min(-nums[i] + relative[i + 1][j], -nums[j] + relative[i][j - 1]);
                }
            }
            play = -play;
        }
        return relative[0][nums.length - 1] >= 0;
    }

    /**
     * 方法2：记忆化递归
     * 在递归时，如果该递归结果已经存储，则不再递归；如果没有，则递归。
     * 在使用常规的递归实现时，递归过程时有一些递归是重复出现，如果将这些重复的递归存储起来，那么就不用重复多次的计算
     *
     * @param nums 整型数组
     * @return 第一个玩家是不是赢家，第1个玩家的分数大于等于第2个玩家时赢
     */
    public boolean PredictTheWinner32(int[] nums) {
        int score = 0;      // 玩家1相对于玩家2的得分
        int[][] memo = new int[nums.length][nums.length];       // 存储递归结果
        score = memoRecursive(nums, 1, 0, nums.length - 1, memo);
        return score >= 0;
    }

    /**
     * @param nums 数组
     * @param play 本次递归时是己方还是对方。play = 1 时，表示是己方在做选择；play = -1时，表示是对方在做选择。
     * @param low  起始下标
     * @param high 结束下标
     * @return 己方和对方的相对得分（得分差）
     */
    private int memoRecursive(int[] nums, int play, int low, int high, int[][] memo) {
        if (low == high) return play == 1 ? nums[low] : -nums[low];
        // 下层递归的结果
        int leftScore = memo[low][high] > 0 ? memo[low][high] : memoRecursive(nums, -play, low + 1, high, memo);
        int rightScore = memo[low][high] > 0 ? memo[low][high] : memoRecursive(nums, -play, low, high - 1, memo);
        // 选择的分数+下层递归的最佳得分。
        // 如果是己方，己方分数是正
        if (play == 1) return Math.max(nums[low] + leftScore, nums[high] + rightScore);
        // 如果是对方，对方分数是负
        return Math.min(-nums[low] + leftScore, -nums[high] + rightScore);
    }

    /**
     * 方法1：递归
     * 相对分数：己方分数为正，对方分数为负。
     * 也就是说，当为正数时，是己方得分较高；当为负数时，是对方得分较高
     *
     * @param nums 整型数组
     * @return 第一个玩家是不是赢家，第1个玩家的分数大于等于第2个玩家时赢
     */
    public boolean PredictTheWinner31(int[] nums) {
        int score = 0;      // 玩家1相对于玩家2的得分
        score = recursive(nums, 1, 0, nums.length - 1);
        return score >= 0;
    }

    /**
     * @param nums 数组
     * @param play 本次递归时是己方还是对方。play = 1 时，表示是己方在做选择；play = -1时，表示是对方在做选择。
     * @param low  起始下标
     * @param high 结束下标
     * @return 己方和对方的相对得分（得分差）
     */
    private int recursive(int[] nums, int play, int low, int high) {
        if (low == high) return play == 1 ? nums[low] : -nums[low];
        // 下层递归的结果
        int leftScore = recursive(nums, -play, low + 1, high);
        int rightScore = recursive(nums, -play, low, high - 1);
        // 选择的分数+下层递归的最佳得分。
        // 如果是己方，己方分数是正
        if (play == 1) return Math.max(nums[low] + leftScore, nums[high] + rightScore);
        // 如果是对方，对方分数是负
        return Math.min(-nums[low] + leftScore, -nums[high] + rightScore);
    }

    /**
     * 下面是一开始试的方法，由于不知道怎么选择是最优的策略，什么策略得到的的是最优的值，
     * 所以在使用常规的回溯和贪心解决时，并不能得到最优值，下面的击中方法看着不同，但是是同一种策略。
     * 1. 不能用回溯。使用回溯穷举所有的可能性，其中，玩家1的得分存在比玩家2高的情况，但是这种情况可能不是在最优的情况下产生的。
     * 这样的话，相当于各玩家在选择时并没有做有利于自己的选择。
     * 回溯无法区分玩家1 得分较高时是否是在双方都是最优选择的条件下。
     * 2. 不能用贪心。玩家在每轮做最优选择时，不能选择本轮中的最大值（仅根据本轮的数据情况做选择）。
     * 因为本轮中的最大值并不能保证最后的总和是最大的。
     * 各玩家在本轮所做的选择，对自己是最优的，对对方是最差的。也就是，让己方得分更多，对方损失更多。
     * 这个思想是正确的，但是单独考虑本轮的情况，也就是贪心的做法，是无法达到全局最优的。
     * 本轮最优做法包括：
     * 1）玩家每次选择两端中的最大值
     * 2）己方2个选择，和对方在己方选择之下的最优选择，选择使得己方收益多，对方损失多的一个选择
     * 3）在己方2个选择中和下轮对方最可能的选择中，若2个选择中对方和己方均增加，则选择对方增加较少/己方增加较多的一个选择；
     * 若2个选择中对方和己方均减少，则选择对方减少较多/己方减少较少的一个选择。
     * 4）本轮选择时，比较己方2个选择加上以前的得分之后的总得分和对方在己方相应选择下的总得分的得分差
     * 其实，本质上还是看己方2个选择中，和对方的差值，而这个差值，只考虑了本轮的差值，并没有考虑全局。
     * 每轮让己方和差值增大或减少，并不能保证最终所有的分数相加是较多的。
     */
}

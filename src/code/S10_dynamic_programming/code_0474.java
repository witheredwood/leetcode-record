package code.S10_dynamic_programming;

import java.util.Arrays;

/**
 * 474. 一和零
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * 提示：
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i]仅由'0' 和'1' 组成
 * 1 <= m, n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0474 {
    /**
     * 动态规划
     * time: O(m*n*k);          space: O(m*n)
     * k 是字符串数组 strs 的长度
     *
     * @param strs 字符串数组
     * @param m    0的个数
     * @param n    1的个数
     * @return 最长子集大小
     */
    public int findMaxForm32(String[] strs, int m, int n) {
        // 统计各字符串中0和1的个数
        int[][] nums = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') nums[i][0]++;
                else nums[i][1]++;
            }
        }
        // 存储不同个数要求下的最大长度
        int[][] len = new int[m + 1][n + 1];        // 因为二维数组只是作为存储使用，主要是记录值，所以遍历时不是更新数组进行遍历更新
        for (int k = 0; k < nums.length; k++) {     // 对于该字符串，更新一遍二维数组
            for (int i = m; i >= nums[k][0]; i--) {     // 由于更新当前值时会用到左上角的值，所以在更新数组时，要从右下角到左上角更新
                for (int j = n; j >= nums[k][1]; j--) {
                    len[i][j] = Math.max(len[i][j], 1 + len[i - nums[k][0]][j - nums[k][1]]);
                }
            }
        }
        return len[m][n];
    }

    /**
     * 回溯，会超出时间限制。
     *
     * @param strs 字符串数组
     * @param m    0的个数
     * @param n    1的个数
     * @return 最长子集大小
     */
    public int findMaxForm31(String[] strs, int m, int n) {
        // 统计各字符串中0和1的个数
        int[][] nums = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') nums[i][0]++;
                else nums[i][1]++;
            }
        }
        return backtracking(nums, 0, 0, 0, 0, m, n);
    }

    private int backtracking(int[][] nums, int index, int len, int x, int y, int m, int n) {
        if (x > m || y > n) return len - 1;
        if (index == nums.length) return len;
        int maxLen = 0;
        for (int i = index; i < nums.length; i++) {
            maxLen = Math.max(maxLen, backtracking(nums, i + 1, len + 1, x + nums[i][0], y + nums[i][1], m, n));
        }
        return maxLen;
    }

    /**
     * 动态规划：0-1背包
     * 使用二维数组存储，dp[i][j]: 最多有 i 个 0 和 j 个 1 的最长子集大小
     * 递推公式 / 状态转移方程，dp[i][j] = max{dp[i][j], dp[i-zeroNum][j-oneNum]+1 }
     * 初始化
     * 推导 dp ，以 strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3 为例，
     * 逐一遍历 strs 数组，对每个字符串判断是否把该字符串放入背包中，每个字符串都要更新一遍 dp 数组
     * "10"                 "0001"           "111001"        "1"              "0"
     * 0 [0,0,0,0]     [0,0,0,0]       [0,0,0,0]       [0,1,1,1]        [0,1,1,1]
     * 1  [0,1,1,1]      [0,1,1,1]         [0,1,1,1]         [0,1,2,2]       [1,2,2,2]
     * 2 [0,1,1,1]      [0,1,1,1]         [0,1,1,1]         [0,1,2,2]       [1,2,3,3]
     * 3 [0,1,1,1]      [0,1,1,1]         [0,1,1,1]         [0,1,2,2]       [1,2,3,3]
     * 4 [0,1,1,1]      [0,1,2,2]        [0,1,2,2]        [0,1,2,3]      [1,2,3,3]
     * 5 [0,1,1,1]      [0,1,2,2]        [0,1,2,2]        [0,1,2,3]      [1,2,3,4]
     * 时间复杂度 O(m*n*k)，空间复杂度 O(m*n) k为字符串的长度
     *
     * @param strs 字符串数组
     * @param m    0的个数
     * @param n    1的个数
     * @return 最长子集大小
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeroNum = 0, oneNum = 0;
            // 计算该字符串中的0、1的个数
            for (char c : s.toCharArray()) {
                if (c == '0') zeroNum++;
                else oneNum++;
            }
            // 更新背包的状态转移方程
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
            System.out.println("s = " + s);
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[m][n];
    }
}

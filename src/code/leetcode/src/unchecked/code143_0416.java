package unchecked;

// 416. 分割等和子集
public class code143_0416 {
    // 解法一：使用二维状态转移方程
    public boolean canPartition1(int[] nums) {
        if (nums.length <= 1) return false;

        // 计算数组总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 和为奇数，不能分成两个和相等的子集
        if (sum % 2 == 1) return false;

        // 状态转移方程
        int[][] dp = new int[nums.length+1][sum/2+1];
        // 逐一判断第i个正数是否能放入总和为j的集合中
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 正数i比子集总和j大，不能放进去
                if (nums[i-1] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j]  = Math.max(dp[i-1][j-nums[i-1]]+nums[i-1], dp[i-1][j]);
                }
            }
        }

        if (dp[nums.length][sum/2] == sum/2) return true;
        return false;
    }

    // 解法二：使用一维状态转移方程
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;

        // 计算数组总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 和为奇数，不能分成两个和相等的子集
        if (sum % 2 == 1) return false;

        // 状态转移方程
        int[] dp = new int[sum/2+1];
        // 逐一判断第i个正数是否能放入总和为j的集合中
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length-1; j > 0; j--) {
                if (nums[i] <= j)
                    dp[j] = Math.max(dp[j-nums[i]]+nums[i], dp[j]);
            }
        }


        if (dp[sum/2] == sum/2) return true;
        return false;
    }

}

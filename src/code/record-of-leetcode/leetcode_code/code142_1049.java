package leetcode_code;

import java.util.*;

// 1049. 最后一块石头的重量 II
public class code142_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        System.out.println("sum=" + sum);
        System.out.println("sum=" + (sum+1)/2);
        int n = stones.length;
        int[][] dp = new int[n+1][sum/2+1];  // 状态转移方程

        for (int i = 1; i < n+1; i++) {
            // 遍历填写每一行
            for (int j = 0; j < sum/2+1; j++) {
                if (stones[i-1] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j-stones[i-1]]+stones[i-1], dp[i-1][j]);
                }
            }
        }

        // 打印状态转移方程
        System.out.println("------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("------------");


        int res = Math.abs(2 * dp[n][sum/2] - sum);
        System.out.println("res="+res);

        return res;
    }
}

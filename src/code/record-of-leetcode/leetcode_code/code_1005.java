package leetcode_code;

import java.util.Arrays;

public class code_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 选取最小的值
        for (int i = 0; i < k; i++) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        // 求和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

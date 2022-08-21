package code.S08_backtracking;

import java.util.Arrays;

public class code_0698 {
    /**
     * @param nums 整数数组
     * @param k    正整数
     * @return 是否有可能把这个数组分成 k 个非空子集
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        System.out.println(Arrays.toString(nums));
        int[] sums = new int[k];
//        boolean res = recursive(nums, k, 0, sum / k, sums);
//        System.out.println(Arrays.toString(sums));
//        return res;
        return recursive(nums, k, 0, sum / k, sums);
    }

    /**
     * 把第 index 个数放在第几个集合中
     */
    private boolean recursive(int[] nums, int k, int index, int target, int[] sums) {
        if (index == nums.length) return true;  // 找到了

        for (int i = 0; i < k; i++) {
            if (sums[i] + nums[index] > target) continue;   // 放不下
            if (i > 0 && sums[i] == sums[i - 1]) continue;
            sums[i] += nums[index];
            boolean res = recursive(nums, k, index + 1, target, sums);
            if (res) return true;
            sums[i] -= nums[index];
        }
        return false;
    }
}

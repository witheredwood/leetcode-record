package unchecked;

public class code_0300 {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int max = 0;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (res[i] < res[j]+1) res[i] = res[j]+1;
                }
            }
            if (res[i] == 0) res[i] = 1;
            if (max < res[i]) max = res[i];
        }

        return max;
    }
}

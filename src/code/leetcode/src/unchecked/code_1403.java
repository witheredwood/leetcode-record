package unchecked;

import java.util.*;

public class code_1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new LinkedList<>();

        // 计算总和
        int sum = 0;
        for (int i: nums) sum += i;
        System.out.println("sum="+sum);

        // 数组排序
        Arrays.sort(nums);
        int cur = 0;
        for (int end = nums.length-1; end >= 0; end--) {
            cur += nums[end];
            res.add(nums[end]);
            if (cur > (sum-cur)){
                break;
            }
        }

        return res;
    }
}

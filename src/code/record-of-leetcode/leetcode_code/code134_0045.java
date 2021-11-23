package leetcode_code;

public class code134_0045 {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j<nums.length && j <= i+nums[i]; j++) {
                if (steps[j] == 0) {
                    steps[j] = steps[i] + 1;
                } else {
                    steps[j] = Math.min(steps[j], steps[i]+1);
                }
            }
//            System.out.print("steps=[");
//            for (int j = 0; j < steps.length; j++) {
//                System.out.print(" "+steps[j]);
//            }
//            System.out.println("]");
        }

        return steps[nums.length-1];
    }
}

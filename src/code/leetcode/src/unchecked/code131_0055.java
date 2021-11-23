package unchecked;

// 55. 跳跃游戏
public class code131_0055 {
     // 解法一
//    public boolean canJump(int[] nums) {
//        boolean[] arrive = new boolean[nums.length];
//        arrive[0] = true;
//
//        // 判断从0是否能到i
//        for (int i = 1; i < nums.length; i++) {
//            isArrive(nums, arrive, i);
//        }
//
//        return arrive[nums.length-1];
//    }
//
//    public void isArrive(int[] nums, boolean[] arrive, int i) {
//        for (int j = 0; j < i; j++) {
//            if (arrive[j] && nums[j]+j>=i) {
//                arrive[i] = true;
//                break;
//            }
//        }
//    }

    // 解法二
//    public boolean canJump(int[] nums) {
//        boolean[] arrive = new boolean[nums.length];
//        arrive[0] = true;
//
//        // 如果位置i可达，那么i跳nums[i]之内的步数都可达
//        for (int i = 0; i < nums.length; i++) {
//            if (arrive[i]) {
//                for (int j = i+1; j <= nums[i]+i && j < nums.length; j++) {
//                    arrive[j] = true;
//                }
//                if (arrive[nums.length-1]) return true;
//            }
//        }
//        return false;
//    }

    // 解法三
    public boolean canJump(int[] nums) {
        int dis = 0; // 能跳到的最远距离，最远距离之内的位置都能跳到。

        // 如果位置i可达，那么i跳nums[i]之内的步数都可达
        for (int i = 0; i < nums.length; i++) {
            if (i > dis) return false;  // 当前位置超过了能跳的最远距离，返回false
            // 当前位置没有超过能跳的最远距离，更新最大距离
            dis = Math.max(dis, i+nums[i]);
        }
        return true;
    }
}

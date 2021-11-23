package leetcode_code;

public class code_1221 {
    public int balancedStringSplit(String s) {

        int num = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                left++;
            }else {
                right++;
            }

            // 判断L、R的个数是否相等
            if (left == right) {
                num++;
                left = 0;
                right = 0;
            }
        }

        return num;
    }
}

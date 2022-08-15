package code.S09_greedy;

public class code_1221 {
    /**
     * @param s 字符串
     * @return 通过分割得到的平衡字符串的 最大数量
     */
    public int balancedStringSplit(String s) {
        int l = 0, r = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }
            if (l == r) count++;
        }
        return count;
    }
}

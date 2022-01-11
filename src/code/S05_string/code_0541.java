package code.S05_string;

import java.util.Arrays;

/**
 * 541. 反转字符串 II
 *
 *
 */
public class code_0541 {
    public String reverseStr(String s, int k) {
        int num = s.length() / k;  // s 中有几个k
        System.out.println("num = " + num);
        for (int i = 0; i <= num; i = i + 2) {
            // 反转 [i, i+1]k 之间的字符串
            int end = (i + 1) * k;
            if (end < s.length()) s = reverse(s, i * k, end);
        }
        // 是否反转剩余的字符
        if (num % 2 == 0) {
            s = reverse(s, num * k, s.length());
        }
        return s;
    }

    public String reverse(String s, int start, int end) {
        if (end > s.length()) return s;
        char[] chars = s.toCharArray();
        for (int i = start, j = end - 1; i < j; i++, j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
        return new String(chars);
    }

}

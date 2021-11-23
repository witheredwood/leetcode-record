package leetcode_code;

import java.util.Arrays;

// 455. 分发饼干
public class code_0455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i]) {
                i++;
            }
        }

        return i;
    }
}

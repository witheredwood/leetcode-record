package leetcode_code;

import java.util.List;

public class code_0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // s字符串的前i个字符是否能被拆分
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for (int i = 0; i < len; i++) {  // 查找前i个字符串
            System.out.println("------------------");
            for (int j = 0; j <= i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i+1))) {
                        dp[i+1] = true;
                        continue;
                    }
            }


            System.out.println("i="+i);
            System.out.print("dp=");
            for (int j = 0; j < len; j++) {
                System.out.print(j+"-"+dp[j]+" ");
            }
            System.out.println();
        }
        return dp[len];
    }
    
    /*
     * 解法二：回溯解法
     * 该算法的时间复杂度较高，不能达到预期。
     * */
    boolean flag = false;
    public boolean wordBreak2(String s, List<String> wordDict) {


        for (int i = 0; i < s.length(); i++) {
            dfs (s, 0, i, wordDict);
        }
        return flag;
    }

    public void dfs (String s, int left, int right, List<String> wordDict) {
        // s中[left,right+1]的子串不在字典中
        if (!wordDict.contains(s.substring(left,right+1)))  return;

        if (right >= s.length()-1) {
            flag = true;
            return;
        }

        for (int i = right+1; i < s.length(); i++) {
            dfs(s, right+1, i, wordDict);
        }
    }
}

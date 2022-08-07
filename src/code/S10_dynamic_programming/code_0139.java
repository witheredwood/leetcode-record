package code.S10_dynamic_programming;

import java.util.Arrays;
import java.util.List;

/**
 * 139.单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定s 是否可以由空格拆分为一个或多个在字典中出现的单词。
 * 说明：拆分时可以重复使用字典中的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0139 {
    /**
     * time: O(n^2);        space: O(n)
     *
     * @param s        字符串
     * @param wordDict 字符串列表
     * @return len 是否可以拆分为字符串列表中单词
     */
    public boolean wordBreak31(String s, List<String> wordDict) {
        // 长度为 i 的子串是否可以由单词表中的单词组成
        boolean[] isSplit = new boolean[s.length() + 1];
        isSplit[0] = true;
        for (int i = 0; i < s.length(); i++) {      // 遍历字符串s
            for (int j = i; j >= 0 && !isSplit[i + 1]; j--) {
                if (isSplit[j] && wordDict.contains(s.substring(j, i + 1)))
                    isSplit[i + 1] = true;     // [0, i] 的字符串长度为 i+1
            }
        }
        return isSplit[s.length()];
    }

    /**
     * 动态规划：完全背包
     *
     * @param s        字符串
     * @param wordDict 字符串列表
     * @return len 是否可以拆分为字符串列表中单词
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        // 先遍历背包在遍历物品
        for (int j = 1; j <= len; j++) {
            for (int i = 0; i < j; i++) {
                String word = s.substring(i, j);  // len 当前遍历到的子串
                if (wordDict.contains(word) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[len];
    }
}

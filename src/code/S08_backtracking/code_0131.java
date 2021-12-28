package code.S08_backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 131.分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0131 {
    /**
     * 回溯：使用参数保存符合条件的结果
     *
     * @param s 字符串
     * @return s分成的多个回文子串
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();  // 保存符合条件的结果的集合
        LinkedList<String> path = new LinkedList<>();  // 保存符合条件的结果
        backtracking(s, 0, res, path);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param s          字符串
     * @param startIndex 字符串开始下标
     * @param res        保存符合条件的结果的集合
     * @param path       保存符合条件的结果
     */
    public void backtracking(String s, int startIndex, List<List<String>> res, LinkedList<String> path) {
        if (startIndex > s.length())
            return;
        if (startIndex == s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 判断是否走到字符串最后
        for (int i = 1; i <= s.length() - startIndex; i++) {
            String current = s.substring(startIndex, startIndex + i);
            if (!isHuiWen(current))
                continue;
            path.add(current);
            backtracking(s, startIndex + i, res, path);
            path.removeLast();
        }
    }

    /**
     * 判断字符串是不是回文串
     *
     * @param s 字符串
     * @return 该字符串是否是回文串
     */
    public boolean isHuiWen(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

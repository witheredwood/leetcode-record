package code.S05_string;

/**
 * 459. 重复的子字符串
 * <p>
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0459 {
    /**
     * 构造新字符串，区分出s有重复子串和没有重复子串的不同
     *
     * @param s 字符串
     * @return 是否有一个可重复的子串
     */
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;  // t 一定有重复的子串s
        // 从t的第二个字符开始查找s，如果s有重复的子串，那么查到的是s的第二个子串开始
        // 如果s没有重复的子串，那么查到的是第二个s的下标
        int index = t.indexOf(s, 1);
        if (index == s.length()) return false;
        return true;
    }
}

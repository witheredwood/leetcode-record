package code.S06_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找共用字符
 * <p>
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1002 {
    /**
     * time: O(n^2);      space: O(1)
     *
     * @param words 字符串数组
     * @return 所有在 words 的每个字符串中都出现的共用字符
     */
    public List<String> commonChars32(String[] words) {
        int[] resultArray = new int[26];
        // 初始化
        for (int i = 0; i < words[0].length(); i++) {
            resultArray[words[0].charAt(i) - 'a']++;
        }
        // 求解
        for (int i = 1; i < words.length; i++) {
            int[] curArray = new int[26];
            // 统计当前字符串的所有字符的个数
            for (int j = 0; j < words[i].length(); j++) {
                curArray[words[i].charAt(j) - 'a']++;
            }
            // 和以前的结果数组合并
            for (int j = 0; j < 26; j++) {
                resultArray[j] = Math.min(curArray[j], resultArray[j]);
            }
        }
        // 得到最终结果
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < resultArray[i]; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }

    /**
     * time: O(n^2 logn);      space: O(n)
     *
     * @param words 字符串数组
     * @return 所有在 words 的每个字符串中都出现的共用字符
     */
    public List<String> commonChars31(String[] words) {
        String pre = words[0];
        for (int i = 1; i < words.length; i++) {
            pre = getCommonFromTwo(pre, words[i]);
        }
        List<String> result = new ArrayList<>(pre.length());
        for (int i = 0; i < pre.length(); i++) {
            result.add(String.valueOf(pre.charAt(i)));
        }
        return result;
    }

    /**
     * time: O(nlogn + mlogm);          space: O(n + m)
     *
     * @param s 字符串
     * @param t 字符串
     * @return 两个字符串的公共字符
     */
    private String getCommonFromTwo(String s, String t) {
        StringBuilder builder = new StringBuilder();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0, j = 0; i < chars1.length && j < chars2.length; ) {
            if (chars1[i] == chars2[j]) {
                builder.append(chars1[i]);
                i++;
                j++;
            } else if (chars1[i] < chars2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return builder.toString();
    }
}

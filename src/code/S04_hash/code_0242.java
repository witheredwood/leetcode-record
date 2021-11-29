package code.S04_hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0242 {
    /**
     * 字母异位词：两个字符中的字符及次数相同
     * 计数+比较。时间复杂度 O（3n），空间复杂度 O（2n）
     * 把 s 和 t 中的每个字符出现的次数分别保存在 map 中，然后比较是否相同
     *
     * @param s 第一个字符串，长度大于1
     * @param t 第二个字符串，长度大于1
     * @return true-t是s的字母异位词，false-t不是s的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map1.containsKey(c)) {
                map1.replace(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (map2.containsKey(c)) {
                map2.replace(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }
        System.out.println("map1 = " + map1.toString());
        System.out.println("map2 = " + map2.toString());
        for (char c : map2.keySet()) {
            if (!map1.containsKey(c) || !map2.get(c).equals(map1.get(c))) return false;
        }
        return true;
    }

    /**
     * 计数+比较优化。时间复杂度 O（2n），空间复杂度 O（n）
     * 把 s 和 t 中的每个字符出现的次数分别保存在 map 中，然后比较是否相同
     *
     * @param s 第一个字符串，长度大于1
     * @param t 第二个字符串，长度大于1
     * @return true-t和s互为字母异位词，false-t和s不是字母异位词
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.replace(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        System.out.println("map = " + map.toString());
        return true;
    }
}

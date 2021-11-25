package code.S02_array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 383. 赎金信
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0383 {
    /**
     * 解法一：遍历两个字符串，分别记录每个字符的个数，然后比较两个字符串中各字符的个数
     *
     * @param ransomNote 赎金信(ransomNote)字符串
     * @param magazine   杂志(magazine)字符串
     * @return 赎金信 ransomNote 能不能由杂志 magazines 里面的字符构成
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 计数
        Map<Character, Integer> mapRansomNote = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (mapRansomNote.containsKey(c)) {
                mapRansomNote.replace(c, mapRansomNote.get(c) + 1);
            } else {
                mapRansomNote.put(c, 1);
            }
        }
        Map<Character, Integer> mapMagazine = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (mapMagazine.containsKey(c)) {
                mapMagazine.replace(c, mapMagazine.get(c) + 1);
            } else {
                mapMagazine.put(c, 1);
            }
        }
        System.out.println("mapRansomNote：" + mapRansomNote.toString());
        System.out.println("mapMagazine：" + mapMagazine.toString());
        // 比较
        for (char c : mapRansomNote.keySet()) {
            if (!mapMagazine.containsKey(c) || mapMagazine.get(c) < mapRansomNote.get(c)) return false;
        }
        return true;
    }

    /**
     * 解法二：遍历赎金信(ransomNote)字符串，判断其中的字符是否能在 杂志(magazine)字符串中找到，如果找不到，则返回 false。
     * 如果能找到，把杂志(magazine)字符串中的该字符置空。直到遍历完赎金信(ransomNote)字符串。
     *
     * @param ransomNote 赎金信(ransomNote)字符串
     * @param magazine 杂志(magazine)字符串
     * @return 赎金信 ransomNote 能不能由杂志 magazines 里面的字符构成
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(Character.toString(c));
            if (index == -1) return false;
            magazine = magazine.replaceFirst(Character.toString(c), "");
        }
        System.out.println("magazine: " + magazine);
        return true;
    }

    /**
     * 解法二优化。在解法二中，会频繁的修改 magazine 字符串，而 String 是不可变字符串，每次修改都会重新创建一个 String 对象
     * 所以在这个方法中，使用可变字符串 StringBuilder 来处理 magazine 字符串的修改。减少多余对象的创建
     *
     * @param ransomNote 赎金信(ransomNote)字符串
     * @param magazine 杂志(magazine)字符串
     * @return 赎金信 ransomNote 能不能由杂志 magazines 里面的字符构成
     */
    public boolean canConstruct3(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        for (char c: ransomNote.toCharArray()) {
            int index = sb.indexOf(Character.toString(c));
            if (index == -1) return false;
            sb.replace(index, index+1, "");
        }
        System.out.println("StringBuilder: " + sb.toString());
        System.out.println("magazine: " + magazine);
        return true;
    }
}

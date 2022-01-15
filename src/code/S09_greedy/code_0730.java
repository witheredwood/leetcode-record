package code.S09_greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0730 {
    /**
     * @param s 字符串
     * @return 划分后的字符串列表
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int start = 0, end = s.lastIndexOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = s.lastIndexOf(s.charAt(i));
            if (i < end) {
                end = lastIndex > end ? lastIndex : end;
            } else if (i > end) {
                start = i;
                end = s.lastIndexOf(s.charAt(i));
            }
            if (i == end) {
                list.add(end - start + 1);
            }
        }
        System.out.println("list = " + list);
        return list;
    }

    /**
     * @param s 字符串
     * @return 划分后的字符串列表
     */
    public List<Integer> partitionLabels2(String s) {
        List<Integer> list = new ArrayList<>();
        int start = 0, end = s.lastIndexOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            // 更新右边界
            end = Math.max(s.lastIndexOf(s.charAt(i)), end);
            // 一个子串的结束位置
            if (i == end) {
                list.add(end - start + 1);
                start = i + 1;
            }
        }
        System.out.println("list = " + list);
        return list;
    }
}

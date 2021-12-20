package code.S08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0017 {

    /**
     * 回溯：使用参数保存符合条件的结果
     *
     * @param digits 数字字符串数组
     * @return 由数字对应的字母组成的组合
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new LinkedList<>();

        List<String> res = new ArrayList<>();  // 存放符合条件的结果的结合
        StringBuilder path = new StringBuilder();  // 存放符合条件的结果
        char[][] list = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        backtracking(digits, 0, res, list, path);
        System.out.println(res.toString());
        return res;
    }

    public void backtracking(String digits, int index, List<String> res, char[][] list, StringBuilder path) {
        if (path.length() == digits.length()) {
            res.add(new String(path));
            return;
        }
        int c = digits.charAt(index) - '2';  // '2'
        for (int i = 0; i < list[c].length; i++) {
            path.append(list[c][i]);
            backtracking(digits, index + 1, res, list, path);
            int len = path.length();
            path.delete(len - 1, len);
        }
    }
}

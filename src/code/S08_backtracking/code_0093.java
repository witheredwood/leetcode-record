package code.S08_backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 93.复原IP地址
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。
 * 你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0093 {
    /**
     * @param s 数字字符串
     * @return 所有数字可能组成的 ip 地址
     */
    public List<String> restoreIpAddresses31(String s) {
        if (s.length() < 4 || s.length() > 12) return new LinkedList<>();
        List<String> path = new LinkedList<>();
        List<String> result = new LinkedList<>();
        backtracking(s, 0, path, result);
        return result;
    }

    /**
     * 使用 List 存储路径
     *
     * @param s          字符串
     * @param startIndex 起始路径
     * @param path       路径
     * @param result     所有路径
     */
    private void backtracking(String s, int startIndex, List<String> path, List<String> result) {
        if (path.size() > 4) return;
        if (startIndex == s.length()) {
            if (path.size() < 4) return;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                builder.append(path.get(i) + ".");
            }
            builder.append(path.get(3));
            result.add(builder.toString());
            return;
        }

        int len = 3;
        if (s.charAt(startIndex) == '0') len = 1; // 不能以0开头
        for (int j = 1; j <= len && startIndex + j <= s.length(); j++) {
            String cur = s.substring(startIndex, startIndex + j);
            if (Integer.parseInt(cur) > 255) continue;
            path.add(cur);
            backtracking(s, startIndex + j, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 使用 StringBuilder 存储路径
     *
     * @param s          字符串
     * @param startIndex 起始路径
     * @param size       路径长度
     * @param path       路径
     * @param result     所有路径
     */
    private void backtracking(String s, int startIndex, int size, StringBuilder path, List<String> result) {
        if (size > 4) return;
        if (startIndex == s.length()) {
            if (size < 4) return;
            path.deleteCharAt(path.length() - 1);
            result.add(path.toString());
            return;
        }
        int len = 3;
        if (s.charAt(startIndex) == '0') len = 1; // 不能以0开头
        for (int j = 1; j <= len && startIndex + j <= s.length(); j++) {
            String cur = s.substring(startIndex, startIndex + j);
            if (Integer.parseInt(cur) > 255) continue;
            int pathLen = path.length();
            path.append(cur + ".");
            backtracking(s, startIndex + j, size + 1, path, result);
            path.delete(pathLen, path.length());
        }
    }

    /**
     * 回溯
     *
     * @param s 数字字符串
     * @return 所有数字可能组成的 ip 地址
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return new LinkedList<>();
        /** 符合条件的结果的集合 */
        List<String> res = new LinkedList<>();
        /** 符合条件的结果 */
        LinkedList<String> path = new LinkedList<>();
        backtracking(s, 0, res, path);
        System.out.println(res);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param s          数字字符串
     * @param startIndex 开始下标
     * @param res        符合条件的结果的集合
     * @param path       符合条件的结果
     */
    public void backtracking(String s, int startIndex, List<String> res, LinkedList<String> path) {
        if (path.size() > 4) return;

        if (startIndex >= s.length()) {
            if (path.size() < 4) return;
            String ip = "";
            for (int i = 0; i < 3; i++) {
                ip += path.get(i) + ".";
            }
            ip += path.get(3);
            res.add(ip);
            return;
        }

        for (int i = 1; i <= 3 && startIndex + i <= s.length(); i++) {
            String current = s.substring(startIndex, startIndex + i);
            // 当前数字是类似 01 这样以 0 开头的，不再继续向下查找
            // 当前数字大于 255，不再继续向下查找
            if (i > 1 && current.charAt(0) == '0' || Integer.parseInt(current) > 255) continue;
            path.add(current);
            backtracking(s, startIndex + i, res, path);
            path.removeLast();
        }
    }
}

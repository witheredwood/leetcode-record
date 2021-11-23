package leetcode_code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class code_0131 {
    List<List<String>> res = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);  // 从i开始查找下一个回文串
//        for (int i = 1; i <= s.length(); i++) {
//            boolean flag = isHuiWen(s.substring(0, i));
//            if (!flag) continue;  // 不是回文串
//            stack.push(s.substring(0, i));
//            backtracking(s, i);  // 从i开始查找下一个回文串
//            stack.pop();
//        }
        return res;
    }
    // 从start开始查找下一个回文串
    public void backtracking (String s, int start) {
        if (start == s.length()) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < stack.size(); i++) {
                list.add(stack.get(i));
            }
            res.add(list);
        }
        for (int i = start+1; i <= s.length(); i++) {
            boolean flag = isHuiWen(s.substring(start, i));
            if (!flag) continue;  // 不是回文串
            stack.push(s.substring(start, i));
            backtracking(s, i);  // 从i开始查找下一个回文串
            stack.pop();
        }
    }
    // 判断字符串是否是回文串
    public boolean isHuiWen (String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}


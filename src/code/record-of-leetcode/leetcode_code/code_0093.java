package leetcode_code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class code_0093 {
    List<String> res = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();

    public List<String> restoreIpAddresses(String s) {
        // IP地址长度在4－12之间
        if (s.length() < 4 || s.length() > 12) return new LinkedList<String>();
        // 从0开始查找，第一个地址
        findIp(s, 0, 1);
        return res;
    }

    public void findIp(String s, int start, int k) {
        System.out.println("------------");
        System.out.println("start=" + start + " k=" + k);
        System.out.print("stack=[");
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println("]");
        if (k >= 4) { // 如果查找到最后一个地址
            if (s.charAt(start)=='0' && start!=s.length()-1) return;

            int end = s.length();
            if (end - start > 3) return;
            int t = Integer.parseInt(s.substring(start, end));
            System.out.println("t=" + t);
            if (t > 255) return;
            stack.push(t);

            String tmp = "";
            for (int i = 0; i < 3; i++) {
                tmp += stack.get(i) + ".";
            }
            tmp += stack.get(3);
            System.out.println("tmp=" + tmp);
            res.add(tmp);
            stack.pop();
            return;
        }
        // 从start开始，查找end。如果满足要求，就递归
        int len = start + 3;
        if (s.charAt(start)=='0') len = start+1;
        for (int end = start + 1; end<=len && end<s.length(); end++) {
            int t = Integer.parseInt(s.substring(start, end));
            if (t > 255) continue;
            stack.push(t);
            findIp(s, end, k + 1);
            stack.pop();
        }
    }
}
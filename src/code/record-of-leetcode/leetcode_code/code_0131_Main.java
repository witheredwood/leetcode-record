package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0131_main {
    public static void main(String[] args) {
//        String s = new String("25525511135");
        String s = "aab";
        System.out.println(s);
        List<List<String>> res = new LinkedList<>();
        code_0131 one = new code_0131();
        res = one.partition(s);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}

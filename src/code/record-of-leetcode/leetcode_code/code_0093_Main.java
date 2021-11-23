package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0093_Main {
    public static void main(String[] args) {
//        String s = new String("25525511135");
        String s = s = "010010";
//        String s = s = "0000";
//        String s = s = "0000";
        System.out.println(s);
        List<String> res = new LinkedList<>();

        code_0093 one = new code_0093();
        res = one.restoreIpAddresses(s);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}

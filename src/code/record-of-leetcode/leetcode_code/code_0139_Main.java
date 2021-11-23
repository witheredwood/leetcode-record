package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0139_Main {
    public static void main(String[] args) {
        code_0139 one = new code_0139();

        List<String> list = new LinkedList<>();
        String[] s = {"dd","ad","da","b"};
        for (String t: s) list.add(t);
        boolean f = one.wordBreak("ddadddbdddadd", list);
        System.out.println(f);

//        List<String> list = new LinkedList<>();
//        String[] s = {"cb","bc"};
//        for (String t: s) list.add(t);
//        boolean f = one.wordBreak("ccbb", list);
//        System.out.println(f);

//        "leetcode"
//        ["leet","code"]
        // ture
//        List<String> list = new LinkedList<>();
//        String[] s = {"leet","code"};
//        for (String t: s) list.add(t);
//        boolean f = one.wordBreak("leetcode", list);
//        System.out.println(f);

//        List<String> list = new LinkedList<>();
//        String[] s = {"apple", "pen"};
//        for (String t: s) list.add(t);
//        boolean f = one.wordBreak("applepenapple", list);
//        System.out.println(f);

        // "cars"
        // ["car","ca","rs"]
        // ture
//        List<String> list = new LinkedList<>();
//        String[] s = {"car","ca","rs"};
//        for (String t: s) list.add(t);
//        boolean f = one.wordBreak("cars", list);
//        System.out.println(f);


//        String[] c = s.split("apple");
//        System.out.println(c.length);
//        for (String t: c)
//            System.out.println(t);
    }
}

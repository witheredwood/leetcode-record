package leetcode_code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class code_0649_Main {
    public static void main(String[] args) {
//        String senate = "DDRRRD";
//        List<Character> list = new LinkedList<>();
//        for (int i = 0; i < senate.length(); i++) {
//            list.add(senate.charAt(i));
//        }
//
//        Iterator<Character> it = list.iterator();
//        while (it.hasNext()) {
//            char me = it.next();
//            char you = 'R';
//            if (me == 'R') you = 'D';
//
//            int index = list.indexOf(you);
//            System.out.println(index);
////            it.;
//        }

        code_0649 one = new code_0649();
        String str =  one.predictPartyVictory("DDRRRR");
        System.out.println("str="+str);

//        String str =  one.predictPartyVictory("DDRRR");
//        System.out.println("str="+str);
    }
}

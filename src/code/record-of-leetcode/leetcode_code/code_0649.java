package leetcode_code;

import java.util.*;

public class code_0649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();  // 存放radiant的队员投票的时间
        Queue<Integer> dire = new LinkedList<>();  // 存放dire的队员投票的时间
        //  按发言时间禁止对方一个人，首选禁言对方下一个要发言的人。
        System.out.println(senate);
        // 初始发言顺序
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }
        System.out.println("radiant="+radiant);
        System.out.println("dire="+dire);
        // 开始发言

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if (radiant.peek() < dire.peek()) {
                dire.remove();
                radiant.add(radiant.remove()+senate.length()); // 己方队员下一次发言时间
            } else {
                radiant.remove();
                dire.add(dire.remove()+senate.length()); // 己方队员下一次发言时间
            }
        }

        if (!radiant.isEmpty()) return "Radiant";
        return "Dire";
    }
}

package leetcode_code;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

// 767. 重构字符串
// 用 map 存储数量，并进行排序？？？
public class code141_0767 {
    public String reorganizeString(String s) {
        if (s.length() <= 1) return s;
        int len = s.length();


        int[] num = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            num[index]++;
            if (num[index] > (len + 1) / 2) return "";
            if (num[index] > max) max = index;
        }


        // 优先级队列。最大堆
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return num[b - 'a'] - num[a - 'a'];
            }
        });
        for (int i = 0; i < 26; i++) {
            if (num[i] > 0) queue.add((char) ('a' + i));
        }


        char[] c = new char[len];

        // 第一遍按奇数位插入，第二遍按偶数位插入
        int i = 0;
        while (i < len && !queue.isEmpty()) {
            c[i] = queue.peek();  // 放入字符
            num[queue.peek() - 'a']--;  // 该字符数量减一
            if (num[queue.peek() - 'a'] <= 0) queue.remove();  // 如果该字符放完，则从队列中移除
            i += 2;  // 隔空放
            if (i >= len) i = 1;  // 第二遍插入
        }

        return new String(c);
    }
}

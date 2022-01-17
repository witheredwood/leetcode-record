package code.S05_string;

import java.util.*;

public class code_0767 {
    public static void main(String[] args) {
        // 76 优先级队列
        int[] num = {0, 3, 5};

        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return num[a - 'a'] - num[b - 'a'];
            }
        });
        queue.add('b');
        queue.add('a');
        queue.add('c');
        System.out.println("num = " + Arrays.toString(num) + " queue = " + queue);
//        System.out.println("num = " + Arrays.toString(num) + " queue = " + queue.poll().toString());
        num[0] = 9;
        queue.poll();
        queue.add((char) ('a' + 1));
        System.out.println("num = " + Arrays.toString(num) + " queue = " + queue);
        System.out.println("------------------------");
        Map<Character, Integer> map = new HashMap<>();
        map.put('b', 4);
        map.put('a', 6);
        map.put('c', 1);
        System.out.println("map = " + map.toString());
        for (Character c : map.keySet()) {
            System.out.println(c);
        }

        Map<Character, Integer> map1 = new LinkedHashMap<>();
        map1.put('b', 4);
        map1.put('a', 6);
        map1.put('c', 1);
        System.out.println("map = " + map1.toString());
        for (Character c : map1.keySet()) {
            System.out.println(c);
        }
    }
}

package leetcode_code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// 406 根据身高排序

public class code_0406 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;  // 有n个人

        // 排序
        //  自己构造比较器
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
               if (a[0] == b[0]) return a[1]-b[1];
               return b[0]-a[0];
            }
        };
        Arrays.sort(people, comparator);
        // 插入
        List<int[]> list = new LinkedList<>();
        for (int i=0; i<n; i++) {
            list.add(people[i][1], people[i]);
        }
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}
package leetcode_code;

import java.util.*;

// 56 合并区间
public class code132_0056 {
    // 解法：排序 + 快慢指针 ==> 合并区间
    public int[][] merge(int[][] intervals) {
        int len = 1;  // 最终结果的数组长度
        // 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // 快慢指针
        int i = 0, j = 1;
        while (j < intervals.length) {
            if (intervals[i][1] >= intervals[j][0]) { // 合并区间
                intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
            } else {
                i++;
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
                len++;
            }
            j++;
        }
        //  输出
        int[][] res = new int[len][2];
        for (int k = 0; k < len ; k++) {
            res[k][0] = intervals[k][0];
            res[k][1] = intervals[k][1];
        }
        return res;
    }

    public void printArray(int[][] arr) {
        System.out.print("res=[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("["+arr[i][0]+","+arr[i][1]+"] ");
        }
        System.out.println("]");

    }
}

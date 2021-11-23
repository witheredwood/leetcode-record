package leetcode_code;

import java.util.Arrays;
import java.util.Comparator;

// 435. 无重叠区间
public class code137_0435 {
    // 按照左端点排序，区间重叠时，去掉右端点大的区间
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;

        // 排序。按照左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });

        int i = 0;
        for (int j = 1; j < intervals.length; j++) {

            // 有重叠，去掉右端点大的区间
            if (intervals[j][0] < intervals[i][1]) {
                if (intervals[j][1] < intervals[i][1]){
                    intervals[i][0] = intervals[j][0];
                    intervals[i][1] = intervals[j][1];
                }
            } else {
                i++;
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
            }


            myPrint(intervals);
            System.out.println("i="+i+" j="+j);
        }

        return intervals.length-(i+1);
    }

    public void myPrint(int[][] intervals){
        System.out.println("-------------");
        System.out.print("intervals=[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(" [" + intervals[i][0]+","+intervals[i][1] + "]");
        }
        System.out.println(" ]");
    }
}

package unchecked;

import java.util.Arrays;
import java.util.Comparator;

// 0452.用最少数量的箭引爆气球
public class code138_0452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        myPrint(points);
        // 排序。排序时，若两数相减的结果超出int范围，则会返回错误的结果
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) return -1;
                else if (a[0] > b[0]) return 1;

                if (a[1] < b[1]) return -1;
                return 1;
            }
        });
        myPrint(points);


        // 找出公共区间，及其个数
        int num = 1;
        for (int i = 0, j = 1; j < points.length; i++,j++) {
            // 有重叠
            if (points[j][0] <= points[i][1]) {
                points[i][0] = Math.max(points[i][0], points[j][0]);
                points[i][1] = Math.min(points[i][1], points[j][1]);
                points[j][0] = Math.max(points[i][0], points[j][0]);
                points[j][1] = Math.min(points[i][1], points[j][1]);
            } else {
                System.out.println("===========");
                System.out.println("num1="+num);
                num++;
                System.out.println("num="+num);
                System.out.println("===========");
            }

            myPrint(points);
        }

        return num;
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

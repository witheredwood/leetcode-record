package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 位运算：计算二进制中1的数量
 * <p>
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_1356 {
    public int[] sortByBits(int[] arr) {
        List<Integer>[] lists = new LinkedList[32];
        // 计数
        for (int i = 0; i < arr.length; i++) {
            if (0 == arr[i]) {
                if (lists[0] == null) lists[0] = new LinkedList<Integer>();
                lists[0].add(0);
            } else {
                int count = 0, tmp = arr[i];
                while (tmp > 0) {
                    count++;
                    tmp &= tmp - 1;
                }
                if (lists[count] == null) lists[count] = new LinkedList<Integer>();
                lists[count].add(arr[i]);
            }
        }
        System.out.println("数组 lists: " + Arrays.deepToString(lists));

        // 排序
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                List<Integer> list = lists[i];
                // 排序
                list.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                for (int val: list) {
                    arr[index++] = val;
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
        return arr;
    }
}

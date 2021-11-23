package leetcode_code;

import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.util.ArrayList;
import java.util.List;

// 738. 单调递增的数字
public class code140_0738 {
//    public int monotoneIncreasingDigits(int n) {
//        List<Integer> list = new ArrayList<>();
//
//        while (n > 0) {
//            list.add(0, n % 10);
//            n = n / 10;
//        }
//
//
//        for (int i = list.size() - 2; i >= 0; i--) {
//            if (list.get(i) > list.get(i + 1)) {
//                list.set(i, list.get(i) - 1);
//                for (int j = i+1; j < list.size(); j++) {
//                    if (list.get(j) != 9) list.set(j, 9);
//                }
//            }
//        }
//
//        int res = 0;
//        for (int t : list) {
//            res = res * 10 + t;
//        }
//        return res;
//    }

    public int monotoneIncreasingDigits(int n) {
        char[] arr = Integer.toString(n).toCharArray();

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                arr[i]--;
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] != '9') arr[j] = '9';
                }
            }
        }


        return  Integer.parseInt(new String(arr));
    }

}

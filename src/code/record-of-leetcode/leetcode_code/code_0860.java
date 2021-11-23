package leetcode_code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class code_0860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) return true;

        // 我当前拥有的5，10，20美元的个数
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(){{
            put(20, 0);
            put(10, 0);
            put(5, 0);
        }};

        // 判断每位顾客是否能够找零
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] > 5){
                int change = bills[i] - 5;  // 需要找的零钱数
                if (change > 0) {
                    // 判断是否能够正确找零
                    boolean f = isChange(map, change);
                    if (!f) return false;
                }
            }

            //  收钱
            int val = map.get(bills[i]);
            map.replace(bills[i], ++val);  // 该位顾客的钱
        }

        return true;
    }
    // 判断是否能够正确找零
    public boolean isChange(Map<Integer, Integer> map, int change) {
        // 从大到小依次查找
        for (int key:map.keySet()) {
            int val = map.get(key);  // 要找的零钱
            if (key <= change && (val>0)) {  // 可以找零了
                int n = change / key;  // 该币值要找几张
                n = Math.min(n, val);
                val -= n;
                map.replace(key, val);

                change = change - key * n;  // 还剩多少零钱要找
            }
        }

        if (change == 0) return true;
        return false;
    }
}

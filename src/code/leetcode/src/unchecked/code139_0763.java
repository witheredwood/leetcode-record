package unchecked;

import java.util.LinkedList;
import java.util.List;

// 763. 划分字母区间
public class code139_0763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();

        int min = 0, max = 0;
        while (min < s.length()) {
            max = s.lastIndexOf(s.charAt(min));  // 该字母的最后一个位置

            for (int i = min; i < max; i++) {
                char c = s.charAt(i);
                int index = s.lastIndexOf(c);
                if (index > max) max = index;
            }
            res.add(max-min+1);

            min = max + 1;  // 下一个片段的起始位置
        }


        return res;
    }
}

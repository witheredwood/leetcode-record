package leetcode_code;

public class code133_0122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int len = prices.length;
        int start = 0, end = 0, sum = 0;
        for (int i = 0; i < len; ) {
            // 找小值
            while (i<len-1 && prices[i] >= prices[i+1]) i++;
            if (i >= len-1) break;
            start = i;
            // 找大值
            while (i<len-1 && prices[i] <= prices[i+1]) i++;
            end  = i;
            // 计算利润
            sum += (prices[end] - prices[start]);
//            System.out.println("start= "+start+" end= "+end+" sum= "+sum);
        }

        return sum;
    }
}

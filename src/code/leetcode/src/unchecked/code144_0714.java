package unchecked;

// 714. 买卖股票的最佳时机含手续费
public class code144_0714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;

        int len = prices.length;
        int start = 0, end = 0, sum = 0;
        for (int i = 0; i < len; ) {
            // 找小值
            while (i<len-1 && prices[i] >= prices[i+1]) i++;
            if (i >= len-1) break;
            start = i;
            // 找大值
            for (; i<len-1; i++){
                if (prices[i] >= prices[i+1] && prices[i]-prices[start] >= fee)
                    break;
            }
            System.out.println("end ==> "+i);
            // 判断这次最高价和上次最高价卖出，哪次能获得更高的利润
            int last = prices[i] - prices[end];  // 上次交易作废
            int now = prices[i] - prices[start] - fee;  // 进行一次交易
            if (end > 0 && last > now) sum += last;
            else  sum += (prices[i] - prices[start] - fee);

            // 更新最高价
            end = i;
            // 计算利润
            System.out.println("start= "+start+" end= "+end+" sum= "+sum);
        }

        return Math.max(sum, 0);
    }
}

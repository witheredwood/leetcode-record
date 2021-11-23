package leetcode_code;

// 0135.分发糖果
public class code136_0135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;

        int[] num = new int[ratings.length];  // 每个孩子分到多少糖果
        num[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] <= ratings[i-1]) {
                num[i] = 1;
                for (int j = i-1; j>=0 && ratings[j]>ratings[j+1] && num[j]<=num[j+1]; j--) {
                    num[j]++;
                }
            } else {
                num[i] = num[i-1] + 1;
            }
//            System.out.println("------------");
//            System.out.print("num=[");
//            for (int j = 0; j < num.length; j++) {
//                System.out.print(" "+num[j]);
//            }
//            System.out.println("]");
        }

        // 计算糖果总数
        int sum = 0;
        for (int tmp: num) {
            sum += tmp;
        }
        return sum;
    }
}

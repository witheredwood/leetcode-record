package unchecked;

public class code144_0714_main {
    public static void main(String[] args) {
        code144_0714 one = new code144_0714();

        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = one.maxProfit(prices, fee);
        System.out.println("res ==> "+res);
    }
}

package leetcode_code;

public class code_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int  n = numBottles;  // 喝的酒总数

        int quo = 0;  // 商
        int rem = 0;  // 余数
        while (numBottles >= numExchange) {
            quo = numBottles / numExchange;
            rem = numBottles % numExchange;
            n += quo;
            numBottles = quo + rem;
        }

        return n;
    }
}

package leetcode_code;

public class code142_1049_Main {
    public static void main(String[] args) {
        code142_1049 one = new code142_1049();
        int[] stones = {2,7,4,1,8,1};
//        int[] stones = {31,26,33,21,40};
        int res = one.lastStoneWeightII(stones);
        System.out.println("res=" + res);
    }
}

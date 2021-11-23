package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0077_Main {
    public static void main(String[] args) {
        int n = 4,  k = 2;
        List<List<Integer>> res = new LinkedList<>();
        code_0077 one = new code_0077();
        res = one.combine(n,  k);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < k; j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
}

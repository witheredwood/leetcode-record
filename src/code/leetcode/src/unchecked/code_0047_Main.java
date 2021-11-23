package unchecked;

import java.util.LinkedList;
import java.util.List;

public class code_0047_Main {
    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {1,2,3};
        List<List<Integer>> res = new LinkedList<>();

        code_0047 one = new code_0047();
        res = one.permuteUnique(nums);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
}

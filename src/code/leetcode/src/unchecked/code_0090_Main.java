package unchecked;

import java.util.LinkedList;
import java.util.List;

public class code_0090_Main {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> res = new LinkedList<>();
        code_0090 one = new code_0090();
        res = one.subsetsWithDup(nums);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
}

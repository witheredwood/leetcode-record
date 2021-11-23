package leetcode_code;

import java.util.LinkedList;
import java.util.List;

public class code_0040_Main {
    public static void main(String[] args) {
        List<List<Integer>> res = new LinkedList<>();
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;
//        int[] candidates = {2,5,2,1,2};
//        int target = 5;
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 27;

        code_0040 one = new code_0040();
        res = one.combinationSum2(candidates, target);

        System.out.println("----------");
        for (List<Integer> tmp: res) {
            System.out.print("[");
            for (int i = 0; i < tmp.size() - 1; i++) {
                System.out.print(tmp.get(i) + ",");
            }
            System.out.println(tmp.get(tmp.size() - 1) + "]");
        }
    }
//    public static void main(String[] args) {
//        Set<List<Integer>> set = new HashSet<>();
//        List<List<Integer>> res = new LinkedList<>();
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return a-b;
//            }
//        };
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(1);
//        list.add(6);
//        list.sort(comparator);
//        set.add(list);
//        res.add(list);
//        list.clear();
//        list.add(1);
//        list.add(6);
//        list.add(1);
//        list.sort(comparator);
//        set.add(list);
//        res.add(list);
//        System.out.println(set.size());
//        System.out.println(res.size());
//    }
}

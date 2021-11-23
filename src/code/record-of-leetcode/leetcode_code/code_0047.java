package leetcode_code;

import java.util.*;

public class code_0047 {
    Set<List<Integer>> set = new HashSet<>();
    Stack<Integer> stack = new Stack();

//    Comparator<Integer>  comparator = new Comparator<Integer>() {
//        public int compare(Integer a, Integer b) {
//            return a-b;
//        }
//    };
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            stack.push(i);
            backtracking(nums, visited, i);
            visited[i] = false;
            stack.pop();
        }
//        System.out.println("set="+set.size());
        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> tmp: set) {
            res.add(tmp);
        }
        return res;
    }

    public void backtracking (int[] nums, boolean[] visited, int i) {
        visited[i] = true;

        if (stack.size() == nums.length) {
//            System.out.println("------------");
//            System.out.print("stack=[");
//            for (int j = 0; j < nums.length; j++) {
//                System.out.print(stack.get(j)+" ");
//            }
//            System.out.println("]");
            List<Integer> tmp = new LinkedList<>();
//            for (int k: stack) {
//                System.out.println("k=" +k);
//                System.out.println("num[k]=" +nums[k]);
//                tmp.add(nums[k]);
//            }
            // 排序

//            System.out.print("[");
//            for (int j = 0; j < nums.length; j++) {
//                System.out.print(tmp.get(j)+" ");
//            }
//            System.out.println("]");

            set.add(tmp);
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!visited[j]) {
                stack.push(j);
                backtracking(nums, visited, j);
                stack.pop();
                visited[j] = false;
            }
        }
    }
}

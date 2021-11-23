package leetcode_code;

import java.util.*;

public class code_0040 {
    List<List<Integer>> res = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    int sum = 0;

    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    };
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       for (int i=0; i<candidates.length; i++) {
            stack.push(i);
           sum += candidates[i];
            backtracking(candidates, target, i);
           sum -= candidates[stack.peek()];
            stack.pop();
        }
       for (List<Integer> tmp : set) {
           res.add(tmp);
       }
       return res;
    }

    public void backtracking (int[] candidates, int target, int i) {
        if (sum > target) return;
        if (sum == target) {
            List<Integer> tmp = new LinkedList<>();
            for (int k: stack)
                tmp.add(candidates[k]);
            tmp.sort(comparator);
            set.add(tmp);
            return;
        }
        // 访问下一层的邻接点
        for (int j=i+1; j<candidates.length; j++) {
            stack.push(j);
            sum += candidates[j];
            backtracking(candidates, target, j);
            sum -= candidates[stack.peek()];
            stack.pop();
        }
    }
}

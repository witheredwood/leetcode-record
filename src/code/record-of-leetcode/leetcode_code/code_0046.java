package leetcode_code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class code_0046 {
    List<List<Integer>> res = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stack.push(i);
            backtracking(nums, visited, i);
            visited[i] = false;
            stack.pop();
        }
        return res;
    }
    public void backtracking (int[] nums, boolean[] visited, int i) {
        visited[i] = true;
        if (stack.size() == nums.length) {
            List<Integer> tmp = new LinkedList<>();
            for (int k: stack) {
                tmp.add(nums[k]);
            }
            res.add(tmp);
            return;
        }

        for (int j=0; j<nums.length; j++) {
            if (!visited[j]) {
                stack.push(j);
                backtracking(nums, visited, j);
                visited[j] = false;
                stack.pop();
            }
        }
    }

}

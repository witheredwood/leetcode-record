package unchecked;

import java.util.*;

public class code_0090 {
    Set<List<Integer>> set = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>()); // 空子集
        for (int k = 1; k <= nums.length; k++) {
                backtrackingOfSubset(nums, k);
        }

        for (List<Integer> tmp: set) {
            res.add(tmp);
        }
        return res;
    }

    public void backtrackingOfSubset (int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stack.push(i);
            backtracking(nums, k, i, visited);
            stack.pop();
            visited[i] = false;
        }
    }

    public void backtracking (int[] nums, int k, int i, boolean[] visited) {
        visited[i] = true;
        if (stack.size() == k) {
            List<Integer> tmp = new LinkedList<>();
            for (int t: stack) {
                tmp.add(nums[t]);
            }
//            tmp.sort(comparator);
            set.add(tmp);
            return;
        }
        for (int j = i+1; j < nums.length; j++) {
            if (!visited[j]) {
                stack.push(j);
                backtracking(nums, k, j, visited);
                stack.pop();
                visited[j] = false;
            }
        }

    }
}

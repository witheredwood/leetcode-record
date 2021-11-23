package unchecked;

import java.util.*;

public class code_0078 {
//    Set<List<Integer>> set = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        res.add(new LinkedList<>()); // 空子集

        for (int k = 1; k < nums.length; k++) {
            backtracingOfSubset(nums, k);  // 查找子集长度=k的所有子集
        }

//        List<List<Integer>> res = new LinkedList<>();

        List<Integer> tmp = new LinkedList<>();
        for (int i: nums) {
            tmp.add(i);
        }
        res.add(tmp); // 数组本身
        return res;
    }

    public void backtracingOfSubset (int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stack.push(i);
            backtracing(nums, i, k, visited);
            stack.pop();
            visited[i] = false;
        }
    }
    public void backtracing (int[] nums, int i, int k, boolean[] visited) {
        visited[i] = true;
        if (stack.size() == k) {
            List<Integer> tmp = new LinkedList<>();
            for (int t: stack) {
                tmp.add(nums[t]);
            }
            res.add(tmp);
            return;
        }
        for (int j = i+1; j < nums.length; j++) {
            stack.push(j);
            backtracing(nums, j, k, visited);
            stack.pop();
            visited[j] = false;
        }
    }
}

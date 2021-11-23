package unchecked;

import java.util.*;

public class code_0077 {
    Set<List<Integer>> set = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> combine(int n, int k) {
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i < n+1; i++) {
            stack.push(i);
            backtracking(n, k, i, visited);
            stack.pop();
            visited[i] = false;
        }

        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> tmp : set) {
            res.add(tmp);
        }
        return res;
    }

    public void backtracking (int n, int k, int i, boolean[] visited) {
        visited[i] = true;
        if (stack.size() == k) {
            List<Integer> tmp = new LinkedList<>();
            for (int t: stack) {
                tmp.add(t);
            }
            set.add(tmp);
            return;
        }
        for (int j = i+1; j < n+1; j++) {
            if (!visited[j]) {
                stack.push(j);
                backtracking(n, k, j, visited);
                stack.pop();
                visited[j] = false;
            }
        }
    }
}

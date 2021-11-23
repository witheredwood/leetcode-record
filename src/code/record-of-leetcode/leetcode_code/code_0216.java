package leetcode_code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class code_0216 {
    List<List<Integer>> res = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 1; i <= 10-k; i++) {
            stack.push(i);
            sum += i;
            dfs(k, n, i);
            stack.pop();
            sum -= i;
        }
        return res;
    }

    private void dfs(int k, int n, int i) {
        if (sum > n) return;   // sum <=n
        if (stack.size() > k) return;  // size <=k
        if (sum == n && stack.size() == k) {
            List<Integer> tmp = new LinkedList<>();
            for (int t: stack) {
                tmp.add(t);
            }
            res.add(tmp);
            return;
        }

        for (int j = i+1; j < 10; j++) {
            stack.push(j);
            sum += j;
            dfs(k, n, j);
            stack.pop();
            sum -= j;
        }
    }

}

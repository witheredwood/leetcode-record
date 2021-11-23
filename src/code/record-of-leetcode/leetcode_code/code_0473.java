package leetcode_code;

import java.util.*;

public class code_0473 {
    int subsum = 0, count = 0;
    Stack<Integer> stack = new Stack<>();

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        Arrays.sort(matchsticks);
        // 计算所有火柴的总长度
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum%4 != 0)  return false;  // 总长度不是4的倍数，则不能组成正方形
        int edge = sum / 4;  // 计算边长
        System.out.println("edge="+edge);

        // 判断是否有4个子集，和=edged
        boolean[] visited = new boolean[matchsticks.length];
//        for (int i = 0; i < matchsticks.length; i++) {
        for (int i = matchsticks.length-1; i >= 0; i--) {
            System.out.println("~~~~~~~~~~~~~");
            System.out.println("i="+i+" matchsticks="+matchsticks[i]);
           if (!visited[i]) {
               subsum += matchsticks[i];
               stack.push(i);
               dfs(matchsticks, i, edge, visited);
               subsum -= matchsticks[i];
               stack.pop();
           }
        }
        return count == 4;
    }
    public void dfs(int[] matchsticks, int i, int edge, boolean[] visited) {
        System.out.println("---------------");
        System.out.println("i="+i+" matchsticks="+matchsticks[i]);

        System.out.println("sum="+subsum);
        if (subsum > edge) {
            return;
        }
        if (subsum == edge) {
            count++;
            System.out.println(stack.size());
            for (int k: stack) {
                visited[k] = true;
//                System.out.println("k="+k+" visited["+k+"]="+visited[k]);
            }
            System.out.println("count="+count);
            return;
        }
//        for (int j = i+1; j < matchsticks.length && !visited[i]; j++) {
        for (int j = i-1; j >= 0 && !visited[i]; j--) {
            if (!visited[j]) {
                subsum += matchsticks[j];
                stack.push(j);
                dfs(matchsticks, j, edge, visited);
                subsum -= matchsticks[j];
                stack.pop();
            }
        }
    }
}

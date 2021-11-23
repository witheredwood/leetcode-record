package leetcode_code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class code_0039 {
    List<List<Integer>> res = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            stack.push(i);
            backtracing(candidates, target, i);
            stack.pop();
        }
        return res;
    }
    public void backtracing (int[] candidates, int target, int i) {
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("i="+i+" can="+candidates[i]);
        int sum = 0;
        System.out.print("stack=" );
        for (int k: stack) {
            sum += candidates[k];
            System.out.print(candidates[k]+" ");
        }
//        for (int k=0; k<stack.size(); k++) {
//            sum += candidates[stack.get(k)];
//            System.out.print(candidates[stack.get(k)]+" ");
//        }
        System.out.println();
        System.out.println("sum="+sum);
        if (sum > target) {
            return;
        }
        if (sum == target) {
            // 数组
            List<Integer> tmp = new LinkedList<>();
            for (int t: stack) {
                tmp.add(candidates[t]);
            }
//            for (int k=0; k<tmp.size(); k++)
//                System.out.print(tmp.get(k)+" ");
            for (int k: tmp) {
                System.out.print(k+" ");
            }
            System.out.println();
            res.add(tmp);
            return;
        }
        // 访问邻接点
        for (int j=i; j < candidates.length; j++) {
            stack.push(j);
            backtracing(candidates, target, j);
            stack.pop();
        }
    }
}

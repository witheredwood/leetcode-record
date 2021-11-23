package unchecked;

import java.util.*;

public class code_0491 {
    Set<List<Integer>> set = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        for (int i = 0; i < nums.length-1; i++) {
            stack.push(nums[i]);
            dfs(nums, i);
            stack.pop();
        }

        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> tmp: set) {
            res.add(tmp);
        }
        return res;
    }

    public void dfs(int[] nums, int index) {
        System.out.println("--------------------");
        System.out.println("stack="+stack);
        if (index >= nums.length-1) return;

        for (int i = index+1; i < nums.length; i++) {
            // 当元素的值不小于前一个元素的值时，才进行遍历
            if (nums[i] >= nums[index]) {
                stack.push(nums[i]);
                dfs(nums, i);
                // 遍历回来时输出当前栈中的元素
                set.add(new LinkedList<>(stack));
                System.out.println("set="+set);
                stack.pop();
            }
        }
    }
}

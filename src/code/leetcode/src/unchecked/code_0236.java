package unchecked;

import java.util.Stack;

public class code_0236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        traverse(root, p, stack1);
        traverse(root, q, stack2);

        TreeNode a = stack1.peek(), b = stack2.peek();
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek().val != stack2.peek().val)
                return a;
            a = stack1.pop();
            b = stack2.pop();

        }
        if (stack1.empty()) return a;
        if (stack2.empty()) return b;
        return root;
    }
    public boolean traverse (TreeNode root, TreeNode p, Stack<TreeNode> stack) {
        if (root == null) return false;
        if (root.val == p.val){
            stack.push(root);
            return true;
        }
        if (traverse(root.left, p, stack) || traverse(root.right, p, stack)) {
            stack.push(root);
            return true;
        }
        return false;
    }
}

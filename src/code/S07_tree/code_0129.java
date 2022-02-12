package code.S07_tree;

public class code_0129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        StringBuilder path = new StringBuilder();
        traverse(root, path);
        return sum;
    }

    public void traverse(TreeNode root, StringBuilder path) {
        if (root.left == null && root.right == null) {
            path.append(root.val);
            sum += Integer.valueOf(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }

        // 访问节点
        path.append(root.val);
        // 遍历子树
        if (root.left != null) traverse(root.left, path);
        if (root.right != null) traverse(root.right, path);
        // 遍历完成之后
        path.deleteCharAt(path.length() - 1);
    }
}

package code.S07_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 遍历方法
 */
public class traverse {
    /**
     * 前序遍历
     */
    public List<Integer> preorder(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        if (root == null) return resultList;
        preorder(root, resultList);
        System.out.println("pre: " + resultList);
        return resultList;
    }

    /**
     * 前序 — 递归
     *
     * @param root 根节点
     * @param list 存储值的列表
     */
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        // 处理节点
        list.add(root.val);
        // 遍历左子树
        if (root.left != null) preorder(root.left, list);
        // 遍历右子树
        if (root.right != null) preorder(root.right, list);
    }

    /**
     * 中序遍历 — 递归
     */
    public List<Integer> inorder(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        if (root == null) return resultList;
        inorder(root, resultList);
        System.out.println("in: " + resultList);
        return resultList;
    }

    /**
     * @param root 根节点
     * @param list 存储值的列表
     */
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        // 遍历左子树
        if (root.left != null) inorder(root.left, list);
        // 处理节点
        list.add(root.val);
        // 遍历右子树
        if (root.right != null) inorder(root.right, list);
    }

    /**
     * 中序遍历
     */
    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            postorder(root, list);
        }
        System.out.println("post: " + list);
        return list;
    }

    /**
     * @param root 根节点
     * @param list 存储值的列表
     */
    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        // 遍历左子树
        if (root.left != null) postorder(root.left, list);
        // 遍历右子树
        if (root.right != null) postorder(root.right, list);
        // 处理节点
        list.add(root.val);
    }

    /**
     * 前序遍历 — 迭代
     */
    public List<Integer> preorderByIter(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop(); // 弹出
            resultList.add(top.val); // 处理节点
            // 加入右子树
            if (top.right != null) stack.push(top.right);
            // 加入左子树
            if (top.left != null) stack.push(top.left);
        }
        System.out.println("pre iter: " + resultList);
        return resultList;
    }

    /**
     * 中序遍历 — 迭代
     */
    public List<Integer> inorderByIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root; // 当前访问的节点
        while (cur != null || stack.size() > 0) {
            if (cur != null) { // 当前访问节点，访问到最底层
                stack.add(cur); // 当前节点不为空，则将该节点加入到栈中
                cur = cur.left;
            } else {
                cur = stack.removeLast(); // 弹出，获取新的节点
                list.add(cur.val); // 处理节点
                cur = cur.right;
            }
        }
        System.out.println("in iter: " + list);
        return list;
    }

    /**
     * 后序遍历 — 迭代
     */
    public List<Integer> postorderByIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop(); // 弹出
            list.add(0, top.val); // 处理节点
            // 加入左子树
            if (top.left != null) stack.push(top.left);
            // 加入右子树
            if (top.right != null) stack.push(top.right);
        }
        System.out.println("post iter: " + list);
        return list;
    }

    /**
     * 层次遍历
     *
     * @return 层次遍历的结果
     */
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            // 出队
            TreeNode curNode = queue.poll();
            // 处理节点
            list.add(curNode.val);
            // 加入左右子树
            if (curNode.left != null) queue.offer(curNode.left);
            if (curNode.right != null) queue.offer(curNode.right);
        }
        System.out.println("levelOrder: " + list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        traverse tra = new traverse();
        List<Integer> list = null;
        // 层次遍历
        list = tra.levelOrder(root);
        System.out.println("---------------------");

        // 递归
        list = tra.preorder(root); // 前序遍历
        System.out.println("---------------------");
        list = tra.inorder(root); // 中序遍历
        System.out.println("---------------------");
        list = tra.postorder(root); // 后序遍历
        // 迭代
        System.out.println("---------------------");
        list = tra.preorderByIter(root); // 前序遍历
        System.out.println("---------------------");
        list = tra.inorderByIter(root); // 中序遍历
        System.out.println("---------------------");
        list = tra.postorderByIter(root); // 后序遍历

    }
}

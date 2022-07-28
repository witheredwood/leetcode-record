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
    public List<Integer> orderByPre(TreeNode root) {
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
    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val); // 处理节点
        // 遍历左子树
        if (root.left != null) preorder(root.left, list);
        // 遍历右子树
        if (root.right != null) preorder(root.right, list);
    }

    /**
     * 中序遍历
     */
    public List<Integer> orderByIn(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            inOrder(root, list);
        }
        System.out.println("in: " + list);
        return list;
    }

    /**
     * @param root 根节点
     * @param list 存储值的列表
     */
    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left != null)
            inOrder(root.left, list);
        list.add(root.val); // 处理节点
        if (root.right != null)
            inOrder(root.right, list);
    }

    /**
     * 中序遍历
     */
    public List<Integer> orderByPost(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            postOrder(root, list);
        }
        System.out.println("post: " + list);
        return list;
    }

    /**
     * @param root 根节点
     * @param list 存储值的列表
     */
    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left != null)
            postOrder(root.left, list);
        if (root.right != null)
            postOrder(root.right, list);
        list.add(root.val); // 处理节点
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
     * 中序遍历（迭代）
     */
    public List<Integer> orderByInIter(TreeNode root) {
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
     * 后序遍历（迭代）
     */
    public List<Integer> orderByPostIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        TreeNode cur;
        while (stack.size() > 0) {
            cur = stack.removeLast(); // 弹出
            list.add(cur.val); // 处理节点
            if (cur.left != null)
                stack.add(cur.left); // 加入左孩子
            if (cur.right != null)
                stack.add(cur.right); // 加入右孩子
        }
        Collections.reverse(list);
        System.out.println("post iter: " + list);
        return list;
    }

    /**
     * 层次遍历
     *
     * @return 层次遍历的结果
     */
    public List<Integer> layer(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (queue.size() > 0) {
            TreeNode cur = queue.remove();
            list.add(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        System.out.println("layer: " + list);
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
        list = tra.layer(root);
        System.out.println("---------------------");

        // 递归
        list = tra.orderByPre(root); // 前序遍历
        System.out.println("---------------------");
        list = tra.orderByIn(root); // 中序遍历
        System.out.println("---------------------");
        list = tra.orderByPost(root); // 后序遍历
        // 迭代
        System.out.println("---------------------");
        list = tra.preorderByIter(root); // 前序遍历
        System.out.println("---------------------");
        list = tra.orderByInIter(root); // 中序遍历
        System.out.println("---------------------");
        list = tra.orderByPostIter(root); // 后序遍历

    }
}

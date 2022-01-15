package code.S07_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0235 {
    /**
     * 递归法
     *
     * @param root 二叉搜索树的根节点
     * @param p    第一个结点
     * @param q    第二个结点
     * @return 两个结点的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new LinkedList<>();
        List<TreeNode> list2 = new LinkedList<>();
        LinkedList<TreeNode> path = new LinkedList<>();
        bk(root, p, list1, path);
        bk(root, q, list2, path);
        TreeNode f = root;
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i).val == list2.get(i).val) {
                f = list1.get(i);
            }
        }
        return f;
    }

    /**
     * @param cur    当前遍历到的结点
     * @param target 要找的的结点
     * @param list   存放路径的链表
     * @param path   访问路径
     * @return 是否找到结点
     */
    public boolean bk(TreeNode cur, TreeNode target, List<TreeNode> list, LinkedList<TreeNode> path) {
        if (cur == null) return false;
        if (cur.val == target.val) {
            list.addAll(new LinkedList<TreeNode>(path));
            return true;
        }
        // 搜索左右子树
        path.add(cur.left);
        boolean l = bk(cur.left, target, list, path);
        path.removeLast();
        if (l) return true;
        path.add(cur.right);
        boolean r = bk(cur.right, target, list, path);
        path.removeLast();
        return r;
    }

    /**
     * 迭代法
     *
     * @param root 二叉搜索树的根节点
     * @param p    第一个结点
     * @param q    第二个结点
     * @return 两个结点的最近公共祖先
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new LinkedList<>();
        List<TreeNode> list2 = new LinkedList<>();
        findNode(root, p, list1);
        findNode(root, q, list2);
        TreeNode f = root;
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i).val == list2.get(i).val) {
                f = list1.get(i);
            }
        }
        return f;
    }

    /**
     * @param root   二叉搜索树的根节点
     * @param target 要查找的目标结点
     * @param list   存放路径
     */
    public void findNode(TreeNode root, TreeNode target, List<TreeNode> list) {
        TreeNode cur = root;
        while (cur.val != target.val) {
            list.add(cur);
            cur = target.val < cur.val ? cur.left : cur.right;
        }
        list.add(cur);
    }
}

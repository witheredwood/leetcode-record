package code.S07_tree;

import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *      int val;
 *      Node *left;
 *      Node *right;
 *      Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点的数量在[0, 2^12- 1]范围内
 * -1000 <= node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_0116 {
    /**
     * time: O(n);      space: O(n)
     *
     * @param root 二叉树根节点
     * @return 填充之后的二叉树根节点
     */
    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        Node last = queue.isEmpty() ? null : queue.getLast();
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left != null) queue.offer(curNode.left);
            if (curNode.right != null) queue.offer(curNode.right);
            if (curNode == last || queue.isEmpty()) {
                if (!queue.isEmpty()) last = queue.getLast();
                curNode.next = null;
            } else {
                curNode.next = queue.peek();
            }
        }
        return root;
    }
}
